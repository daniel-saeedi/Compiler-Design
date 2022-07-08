grammar SimpleLOOP;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.classDec.classMembersDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 }

simpleLOOP returns [Program simpleLOOPProgram]:
    NEWLINE* p = program {$simpleLOOPProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (v = varDecStatement NEWLINE+
    {
        for (VariableDeclaration varDec: $v.varDecStmtRet)
            $programRet.addGlobalVariable(varDec);
    }
    )*
    (c = classDeclaration NEWLINE+ {$programRet.addClass($c.classDeclarationRet);})*;

//todo
constructor returns[ConstructorDeclaration constructorDeclarationRet]:
      PUBLIC init = INITIALIZE
      mArgs=methodArgsDec NEWLINE* m=methodBody
      {
        $constructorDeclarationRet = new ConstructorDeclaration();
        $constructorDeclarationRet.setLine($init.getLine());
        $constructorDeclarationRet.setBody($m.methodBodyRet);
        $constructorDeclarationRet.setLocalVars($m.localVars);
        $constructorDeclarationRet.setArgs($mArgs.args);
      };

//todo
classDeclaration returns[ClassDeclaration classDeclarationRet]
    : line = CLASS
     c = class_identifier {$classDeclarationRet = new ClassDeclaration($c.class_id);
                       $classDeclarationRet.setLine($line.getLine());}
    (LESS_THAN cid2=class_identifier
            { $classDeclarationRet.setParentClassName($cid2.class_id); }
        )?
    NEWLINE* ((LBRACE NEWLINE+ (field_decleration[$classDeclarationRet] NEWLINE+)+ RBRACE) | (field_decleration[$classDeclarationRet]));
//todo
field_decleration[ClassDeclaration classDecl]
    :
    ((
    ( accessType=(PUBLIC | PRIVATE) (
        v = varDecStatement
        {
            FieldDeclaration fd = new FieldDeclaration($v.singleVarDeclRet, $accessType.text == "private" ? true : false);
            fd.setLine($accessType.getLine());
            $classDecl.addField(fd);
        }
        | m = method
        {
            MethodDeclaration newMethod = new MethodDeclaration($m.id,$m.returnType, $accessType.text == "private" ? true : false);
            newMethod.setArgs($m.args);
            newMethod.setBody($m.mBody);
            newMethod.setLocalVars($m.localVars);
            newMethod.setLine($accessType.getLine());
            $classDecl.addMethod(newMethod);
        }
        ))

     | c = constructor
     {
         $classDecl.setConstructor($c.constructorDeclarationRet);
     }
     ));

//todo
method returns [MethodDeclaration methodRet, Identifier id,Type returnType,ArrayList<VariableDeclaration> args,ArrayList<Statement> mBody,ArrayList<VariableDeclaration> localVars]
    : (t=type)
     id_ = identifier mArgs = methodArgsDec NEWLINE* mBody_ = methodBody
     {
        $id = $id_.id;
        $args = $mArgs.args;
        $mBody = $mBody_.methodBodyRet;
        $returnType = $t.typeRet;
        $localVars = $mBody_.localVars;
     }
     | (VOID)
           id_ = identifier mArgs = methodArgsDec NEWLINE* mBody_ = methodBody
           {
              $id = $id_.id;
              $args = $mArgs.args;
              $mBody = $mBody_.methodBodyRet;
              $returnType = new VoidType();
              $localVars = $mBody_.localVars;
           };

//todo: done
methodBody returns[ArrayList<Statement> methodBodyRet,ArrayList<VariableDeclaration> localVars]
    :
    {$methodBodyRet = new ArrayList<Statement>();
    $localVars = new ArrayList<VariableDeclaration>();}
    (LBRACE NEWLINE+ (v = varDecStatement {$localVars.addAll($v.varDecStmtRet);} NEWLINE+)*
     (s = singleStatement {$methodBodyRet.add($s.singleStmntRet);} NEWLINE+)* RBRACE)
    | ((v = varDecStatement {$localVars = $v.varDecStmtRet;}) | (s=singleStatement {$methodBodyRet.add($s.singleStmntRet);}));

//todo: done
methodArgsDec returns [ArrayList<VariableDeclaration> args]
    :
    {$args = new ArrayList<VariableDeclaration>();}
    line=LPAR
    (arg=argDec[$line.getLine()] {$args.add($arg.arg);} ((ASSIGN orExpression) | (COMMA arg = argDec[$line.getLine()] {$args.add($arg.arg);})*) (COMMA arg=argDec[$line.getLine()] {$args.add($arg.arg);} ASSIGN orExpression)*)? RPAR ;

//todo: done
argDec[int line] returns [VariableDeclaration arg]: t=type id=identifier
       {$arg = new VariableDeclaration($id.id,$t.typeRet); $arg.setLine($line);};

//todo: done
methodArgs returns [ArrayList<Expression> methodArgsRet]:
    {$methodArgsRet = new ArrayList<Expression>();}
    (e1 = expression {$methodArgsRet.add($e1.expressionRet);} (COMMA e2=expression {$methodArgsRet.add($e2.expressionRet);})*)?;


//todo: done
body returns [Statement bodyRet]
    :
     (b = blockStatement
     {
        $bodyRet = $b.blockStatementRet;
     }
     | (NEWLINE+ s = singleStatement {$bodyRet = $s.singleStmntRet;}));

//todo: done
blockStatement returns [BlockStmt blockStatementRet]
    locals [ArrayList<Statement> stmts]
    :
    {$stmts = new ArrayList<Statement>();}
    l = LBRACE NEWLINE+ (s = singleStatement {$stmts.add($s.singleStmntRet);}  NEWLINE+)* RBRACE
    {
        $blockStatementRet = new BlockStmt($stmts);
        $blockStatementRet.setLine($l.getLine());
    };

//todo
singleStatement returns [Statement singleStmntRet]
    :
    i = ifStatement
    {
        $singleStmntRet = $i.ifStatementRet;
    }
    | pr = printStatement
    {
        $singleStmntRet = $pr.printStatementRet;
    }
    | mCall = methodCallStmt
    {
        $singleStmntRet = $mCall.methodCallStmtRet;
    }
    | r = returnStatement
    {
        $singleStmntRet = $r.returnStatementRet;
    }
    | as = assignmentStatement
    {
        $singleStmntRet = $as.assignmentStatementRet;
    }
    | l = loopStatement
    {
        $singleStmntRet = $l.loopStatementRet;
    }
    | addS = addStatement
    {
        $singleStmntRet = $addS.addStatementRet;
    }
    | m = mergeStatement
    {
        $singleStmntRet = $m.mergeStatementRet;
    }
    | d = deleteStatement
    {
        $singleStmntRet = $d.deleteStatementRet;
    }
    ;

//todo: done
addStatement returns [Statement addStatementRet]
    :
    lv=expression DOT add = ADD LPAR rv=orExpression RPAR
    {
        $addStatementRet = new SetAdd($lv.expressionRet,$rv.orExpressionRet);
        $addStatementRet.setLine($add.getLine());
    };

//todo: not done
mergeStatement returns [Statement mergeStatementRet]
    :
    lv = expression DOT merge = MERGE LPAR rv = orExpression
    (COMMA orExpression)* RPAR

;

//todo: done
deleteStatement returns [Statement deleteStatementRet]
    :
    lv = expression DOT delete = DELETE LPAR rv = orExpression RPAR
    {
        $deleteStatementRet = new SetDelete($lv.expressionRet,$rv.orExpressionRet);
        $deleteStatementRet.setLine($delete.getLine());
    };

//todo: done
varDecStatement returns [ArrayList<VariableDeclaration> varDecStmtRet, VariableDeclaration singleVarDeclRet]:
    {$varDecStmtRet =  new ArrayList<VariableDeclaration>();}
    t = type id = identifier
     {
          VariableDeclaration newVar = new VariableDeclaration($id.id,$t.typeRet);
          newVar.setLine($id.line);
          $varDecStmtRet.add(newVar);

          $singleVarDeclRet = newVar;
     }
     (COMMA id2 = identifier
     {
        VariableDeclaration newVar2 = new VariableDeclaration($id2.id,$t.typeRet);
        newVar2.setLine($id2.line);
        $varDecStmtRet.add(newVar2);
     }
     )*;

//todo: not complete because of single statement
ifStatement returns[ConditionalStmt ifStatementRet]
            locals [ArrayList<ElsifStmt> elifStmts]
    :
    ifKeyword = IF cond = condition bRet = body
    {
        $ifStatementRet = new ConditionalStmt($cond.conditionRet,$bRet.bodyRet);
        $ifStatementRet.setLine($ifKeyword.line);
    }

    {$elifStmts = new ArrayList<ElsifStmt>();}
    (elif = elsifStatement {$elifStmts.add($elif.elsifStatementRet);})*

    (els = elseStatement
    {
        $ifStatementRet.setElseBody($els.bodyRet);
    }
    )?
    ;

//todo: done
elsifStatement returns[ElsifStmt elsifStatementRet]
    :
     NEWLINE* elif = ELSIF cond = condition b = body
     {
        $elsifStatementRet = new ElsifStmt($cond.conditionRet,$b.bodyRet);
        $elsifStatementRet.setLine($elif.line);
     };

//todo: done
condition returns [Expression conditionRet]
    :
    (LPAR e = expression {$conditionRet = $e.expressionRet;} RPAR) | (e = expression {$conditionRet = $e.expressionRet;});

//todo: not done because of single statement
elseStatement returns[Statement bodyRet, int line]
    :
    NEWLINE* el = ELSE b = body
    {
        $line = $el.getLine();
        $bodyRet = $b.bodyRet;
    }
    ;

//todo: done
printStatement returns [PrintStmt printStatementRet]
    :
    print = PRINT LPAR e = expression RPAR
    {
        $printStatementRet = new PrintStmt($e.expressionRet);
        $printStatementRet.setLine($print.line);
    };

//todo: done(Maybe)
methodCallStmt returns [MethodCallStmt methodCallStmtRet]
    :
    ae = accessExpression
    (lpar = LPAR mArgs = methodArgs RPAR)
    // Method Call
    {
        MethodCall methodCall = new MethodCall($ae.accessExpressionRet, $mArgs.methodArgsRet);
        methodCall.setLine($lpar.getLine());
        $methodCallStmtRet = new MethodCallStmt(methodCall);
        $methodCallStmtRet.setLine($lpar.getLine());
    }
    ;

//todo: done
returnStatement returns[ReturnStmt returnStatementRet]:
        {$returnStatementRet = new ReturnStmt();}
        r = RETURN {$returnStatementRet.setLine($r.getLine());}
        (exp = expression {$returnStatementRet.setReturnedExpr($exp.expressionRet);})?;

//todo: done
assignmentStatement returns [AssignmentStmt assignmentStatementRet]
    :
    oe = orExpression a=ASSIGN e = expression

    {
        $assignmentStatementRet = new AssignmentStmt($oe.orExpressionRet,$e.expressionRet);
        $assignmentStatementRet.setLine($a.getLine());
    };

//todo: not done because of single statement
loopStatement returns [EachStmt loopStatementRet]
    :
    ae = accessExpression DOT each = EACH DO BAR var = identifier BAR b = body
    {
        $loopStatementRet = new EachStmt($var.id,$ae.accessExpressionRet);
        $loopStatementRet.setLine($each.getLine());
        $loopStatementRet.setBody($b.bodyRet);
    };

//todo: not done
expression returns [Expression expressionRet]
    :
    oe1 = ternaryExpression { $expressionRet = $oe1.ternaryExpressionRet; }
    (a=ASSIGN e=expression
    {
        BinaryOperator op = BinaryOperator.assign;
        $expressionRet = new BinaryExpression($oe1.ternaryExpressionRet, $e.expressionRet, op);
        $expressionRet.setLine($a.getLine());
    }
    )?
    (DOT inc=INCLUDE LPAR oe2=orExpression RPAR
    {
        $expressionRet = new SetInclude($expressionRet, $oe2.orExpressionRet);
        $expressionRet.setLine($inc.getLine());
    }
    )?
;
//todo: maybe done
ternaryExpression returns [Expression ternaryExpressionRet]
    :
    oe = orExpression { $ternaryExpressionRet = $oe.orExpressionRet;}
    (t1 = TIF trueExp = ternaryExpression
    t2 = TELSE falseExp = ternaryExpression
    {
        TernaryOperator op = TernaryOperator.ternary;
        $ternaryExpressionRet = new TernaryExpression($oe.orExpressionRet, $trueExp.ternaryExpressionRet, $falseExp.ternaryExpressionRet);
        $ternaryExpressionRet.setLine($t1.getLine());
    }
    )?;

//todo: done
orExpression returns [Expression orExpressionRet]
    :
    ael=andExpression
    { $orExpressionRet = $ael.andExpressionRet; }
    (o=OR aer=andExpression
    {
        BinaryOperator op = BinaryOperator.or;
        $orExpressionRet = new BinaryExpression($orExpressionRet, $aer.andExpressionRet, op);
        $orExpressionRet.setLine($o.getLine());
    }
    )*
    ;

//todo: done
andExpression returns[Expression andExpressionRet]:
        eel=equalityExpression
        { $andExpressionRet = $eel.equalityExpressionRet; }
        (a=AND ee2=equalityExpression
        {
            BinaryOperator op = BinaryOperator.and;
            $andExpressionRet = new BinaryExpression($andExpressionRet, $ee2.equalityExpressionRet, op);
            $andExpressionRet.setLine($a.getLine());
        }
        )*
        ;

//todo: done
equalityExpression returns[Expression equalityExpressionRet]
                   locals[BinaryOperator op, int line]:
    rel=relationalExpression
    { $equalityExpressionRet = $rel.relationalExpressionRet; }
    (eq=EQUAL
    {
        $op = BinaryOperator.eq;
        $line = $eq.getLine();
    }
    rer=relationalExpression
    {
        $equalityExpressionRet = new BinaryExpression($equalityExpressionRet, $rer.relationalExpressionRet, $op);
        $equalityExpressionRet.setLine($line);
    }
    )*
    ;


//todo: done
relationalExpression returns[Expression relationalExpressionRet]
                     locals[BinaryOperator op, int line]:
    ael=additiveExpression
    { $relationalExpressionRet = $ael.additiveExpressionRet; }
    ((gt=GREATER_THAN
    {
        $op = BinaryOperator.gt;
        $line = $gt.getLine();
    }
    | lt=LESS_THAN
    {
        $op = BinaryOperator.lt;
        $line = $lt.getLine();
    }
    ) aer=additiveExpression
    {
        $relationalExpressionRet = new BinaryExpression($relationalExpressionRet, $aer.additiveExpressionRet, $op);
        $relationalExpressionRet.setLine($line);
    }
    )*
    ;


//todo: done biyach
additiveExpression returns[Expression additiveExpressionRet]
                   locals[BinaryOperator op, int line]:
                   mel=multiplicativeExpression
                   { $additiveExpressionRet = $mel.multiplicativeExpressionRet; }
                   ((add=PLUS
                   {
                       $op = BinaryOperator.add;
                       $line = $add.getLine();
                   }
                   | sub=MINUS
                   {
                       $op = BinaryOperator.sub;
                       $line = $sub.getLine();
                   }
                   ) mer=multiplicativeExpression
                   {
                       $additiveExpressionRet = new BinaryExpression($additiveExpressionRet, $mer.multiplicativeExpressionRet, $op);
                       $additiveExpressionRet.setLine($line);
                   }
                   )*
                   ;



//todo: done
multiplicativeExpression returns[Expression multiplicativeExpressionRet]
            locals[BinaryOperator op, int line]:
            pel=preUnaryExpression
            { $multiplicativeExpressionRet = $pel.preUnaryExpressionRet; }
            ((mult=MULT
            {
                $op = BinaryOperator.mult;
                $line = $mult.getLine();
            }
            | div=DIVIDE
            {
                $op = BinaryOperator.div;
                $line = $div.getLine();
            }
            ) per=preUnaryExpression
            {
                $multiplicativeExpressionRet = new BinaryExpression($multiplicativeExpressionRet, $per.preUnaryExpressionRet, $op);
                $multiplicativeExpressionRet.setLine($line);
            }
            )*
            ;




//todo: done
preUnaryExpression returns[Expression preUnaryExpressionRet]
                   locals[UnaryOperator op, int line]:
                   (not=NOT
                   {
                       $op = UnaryOperator.not;
                       $line = $not.getLine();
                   }
                   | minus=MINUS
                   {
                       $op = UnaryOperator.minus;
                       $line = $minus.getLine();
                   }
                   ) pre=preUnaryExpression
                   {
                       $preUnaryExpressionRet = new UnaryExpression($pre.preUnaryExpressionRet, $op);
                       $preUnaryExpressionRet.setLine($line);
                   }
                   | pue=postUnaryExpression
                   { $preUnaryExpressionRet = $pue.postUnaryExpressionRet; }
                   ;

//todo: Done (Not Sure)
postUnaryExpression returns [Expression postUnaryExpressionRet]
                    locals[UnaryOperator op, int line]
    :
    ae = accessExpression
    {
        $postUnaryExpressionRet = $ae.accessExpressionRet;
    }
    (
    (inc = INC
    {
        $op = UnaryOperator.postinc;
        $line = $inc.getLine();
    }
    | dec = DEC
    {
        $op = UnaryOperator.postdec;
        $line = $dec.getLine();
    })
    {
        $postUnaryExpressionRet = new UnaryExpression($ae.accessExpressionRet, $op);
        $postUnaryExpressionRet.setLine($line);
    }
    )?
    ;

//todo: Done (Not Sure)
accessExpression returns[Expression accessExpressionRet]:
    oe=otherExpression
    { $accessExpressionRet = $oe.otherExprRet; }
    (
        (l1=LPAR m=methodArgs RPAR)
        // Method Call
        {
            $accessExpressionRet = new MethodCall($accessExpressionRet, $m.methodArgsRet);
            $accessExpressionRet.setLine($l1.getLine());
        }
        | (dot = DOT (
            id = identifier
            // Object member access
            {
                $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, $id.id);
                $accessExpressionRet.setLine($dot.getLine());
            }
            | n = NEW
            // New Class Instance
            {
                $accessExpressionRet = new NewClassInstance($oe.ct);
                $accessExpressionRet.setLine($n.getLine());
            }
            | init = INITIALIZE
            {
                Identifier id = new Identifier($init.text);
                id.setLine($init.getLine());
                $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, id);
                $accessExpressionRet.setLine($init.getLine());
            }
            ))

    )*



        (

        // Object member access
        (dot = DOT (id = identifier {
                 $accessExpressionRet = new ObjectMemberAccess($accessExpressionRet, $id.id);
                $accessExpressionRet.setLine($dot.getLine());
            })
        )
        | (lbrack = LBRACK exp = expression
            {
                 $accessExpressionRet = new ArrayAccessByIndex($accessExpressionRet, $exp.expressionRet);
                $accessExpressionRet.setLine($lbrack.getLine());
            }

            RBRACK))*;

//todo: Done(Not Sure)
otherExpression returns[Expression otherExprRet, ClassType ct]:
    c = class_identifier
    {
        $otherExprRet = $c.class_id;
        $ct = new ClassType($c.class_id);
    }
    | v = value { $otherExprRet = $v.valueRet; }
    | id = identifier { $otherExprRet = $id.id; }
    | s = setNew
    {
        $otherExprRet = $s.setNewRet;
    }
    | lpar = LPAR exp = expression RPAR
    {
        $otherExprRet = $exp.expressionRet;
        $otherExprRet.setLine($lpar.getLine());
    }
    | self = SELF
    {
        $otherExprRet = new SelfClass();
        $otherExprRet.setLine($self.getLine());
    }
    ;

//todo: not done
setNew returns [SetNew setNewRet]
       locals[ArrayList<Expression> arguments]:
    set = SET DOT NEW LPAR
    {$arguments = new ArrayList<Expression>();}
    (LPAR exp = orExpression {$arguments.add($exp.orExpressionRet);}
    (COMMA exp = orExpression {$arguments.add($exp.orExpressionRet);} )* RPAR)?  RPAR
    {
        $setNewRet = new SetNew($arguments);
        $setNewRet.setLine($set.line);
    }
;

//todo: done
value returns[Value valueRet]:
        bool=boolValue
        {
            $valueRet = new BoolValue($bool.boolValueRet);
            $valueRet.setLine($bool.line);
        }
        | i=INT_VALUE
        {
            $valueRet = new IntValue($i.int);
            $valueRet.setLine($i.getLine());
        }
;

//todo: done
boolValue  returns[boolean boolValueRet, int line]:
tr=TRUE
{
    $boolValueRet = true;
    $line = $tr.getLine();
}
| fa=FALSE
{
  $boolValueRet = false;
  $line = $fa.getLine();
}
;

//todo : Done(Not Sure)
class_identifier returns [Identifier class_id,int line]
    :
    c = CLASS_IDENTIFIER
         {
            $class_id = new Identifier($c.text);
            $class_id.setLine($c.getLine());
         }
;

//todo: done
identifier returns [Identifier id, int line]
       :   identifierLine = IDENTIFIER
       {
           $id = new Identifier($identifierLine.text);
           $id.setLine($identifierLine.getLine());

           $line = $identifierLine.getLine();
       }
;

//todo
type returns [Type typeRet]
    :
    INT
     { $typeRet = new IntType(); }
    | BOOL
      { $typeRet = new BoolType(); }
    | a = array_type
      { $typeRet = $a.arrayTypeRet; }
    | f = fptr_type
      { $typeRet = $f.fptrTypeRet; }
    | s = set_type
      { $typeRet = $s.setTypeRet; }
    | c = class_identifier
      {
            $typeRet  = new ClassType($c.class_id);
      }
    ;

//todo: done
array_type returns [ArrayType arrayTypeRet]
    locals[Type elemType, ArrayList<Expression> dim]
    :
    (INT
    { $elemType = new IntType(); }
    | BOOL
    { $elemType = new BoolType(); }
    | c = class_identifier
    { $elemType  = new ClassType($c.class_id); }
    )
    {$dim = new ArrayList<Expression>();}
    (LBRACK exp = expression {$dim.add($exp.expressionRet);} RBRACK)+
    { $arrayTypeRet = new ArrayType($elemType, $dim); }
    ;

//todo: done
fptr_type returns[FptrType fptrTypeRet]
    locals[ArrayList<Type> argsTypes, Type returnType]:
    FPTR LESS_THAN
    (VOID
    { $argsTypes = new ArrayList<Type>(); }
    | types=typesWithComma
    { $argsTypes = $types.typesWithCommaRet; }
    ) ARROW
    (VOID
    { $returnType = new VoidType(); }
    | t=type
    { $returnType = $t.typeRet; }
    ) GREATER_THAN
    { $fptrTypeRet = new FptrType($argsTypes, $returnType); }
    ;

typesWithComma returns[ArrayList<Type> typesWithCommaRet]:
    { $typesWithCommaRet = new ArrayList<>(); }
    t1=type
    { $typesWithCommaRet.add($t1.typeRet); }
    (COMMA t2=type
    { $typesWithCommaRet.add($t2.typeRet); }
    )*
    ;

//todo: Done
set_type returns [SetType setTypeRet]:
    SET LESS_THAN (INT) GREATER_THAN { $setTypeRet = new SetType(); };

LINE_BREAK: ('//\n') -> skip;

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
NEW: 'new';
SELF: 'self';


RETURN: 'return';
VOID: 'void';


DELETE: 'delete';
INCLUDE: 'include';
ADD: 'add';
MERGE: 'merge';
PRINT: 'print';


IF: 'if';
ELSE: 'else';
ELSIF: 'elsif';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';
INC: '++';
DEC: '--';

EQUAL: '==';
GREATER_THAN: '>';
LESS_THAN: '<';

ARROW: '->';
BAR: '|';

AND: '&&';
OR: '||';
NOT: '!';

TIF: '?';
TELSE: ':';

TRUE: 'true';
FALSE: 'false';
NULL: 'null';

BEGIN: '=begin';
END: '=end';

INT: 'int';
BOOL: 'bool';
FPTR: 'fptr';
SET: 'Set';
EACH: 'each';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
SEMICOLON: ';' -> skip;
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_IDENTIFIER: [A-Z][A-Za-z0-9_]*;

COMMENT: '#' .*? '\n' -> skip;
MLCOMMENT: ('=begin' .*? '=end') -> skip;
WS: ([ \t\r]) -> skip;
