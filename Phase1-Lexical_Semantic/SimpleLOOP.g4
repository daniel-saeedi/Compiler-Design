grammar SimpleLOOP;

simpleLoop: program EOF;

program: globalVarDeclList classDeclList;
classDeclList:  classDecl |;
classDecl: CLASS id=CLASS_ID {System.out.println("ClassDec : "+$id.text);} LBRACE insideClass RBRACE classDecl |
           CLASS id=CLASS_ID {System.out.println("ClassDec : "+$id.text);} insideClassSingle classDecl |
           CLASS id=CLASS_ID LESS_THAN inherit=CLASS_ID {System.out.println("ClassDec : "+$id.text);} {System.out.println("Inheritance : "+$id.text + " < "+$inherit.text);} LBRACE insideClass RBRACE classDecl|;

insideClassSingle: classScopedVarSingle|methodDeclMultipleStatementSingleClass|methodDeclSingleStatementSingle|;
insideClass: classScopedVar|methodDeclMultipleStatement|methodDeclSingleStatement|;
classScopedVar: accessType varDecl insideClass|;
classScopedVarSingle: accessType varDecl|;

methodDeclMultipleStatement
    : accessType methodType id=IDENTIFIER {System.out.println("MethodDec : "+$id.text);} LPAR methodParam RPAR
    LBRACE insideMethodMultipleStatement RBRACE insideClass|
    PUBLIC INITIALIZE LPAR methodParam RPAR
    LBRACE insideMethodMultipleStatement RBRACE insideClass|;

methodDeclMultipleStatementSingleClass
    : accessType methodType id=IDENTIFIER {System.out.println("MethodDec : "+$id.text);} LPAR methodParam RPAR
    LBRACE insideMethodMultipleStatement RBRACE |
    PUBLIC INITIALIZE LPAR methodParam RPAR
    LBRACE insideMethodMultipleStatement RBRACE|;

methodDeclSingleStatement
    : accessType methodType id=IDENTIFIER {System.out.println("MethodDec : "+$id.text);} LPAR methodParam RPAR
    insideMethodSingleStatement insideClass|
    PUBLIC INITIALIZE LPAR methodParam RPAR
    insideMethodSingleStatement insideClass|
    ;

methodDeclSingleStatementSingle
    : accessType methodType id=IDENTIFIER {System.out.println("MethodDec : "+$id.text);} LPAR methodParam RPAR
    insideMethodSingleStatement|
    PUBLIC INITIALIZE LPAR methodParam RPAR
    insideMethodSingleStatement|
    ;

methodParam:
    CLASS_ID arrayBrack id=IDENTIFIER {System.out.println("ArgumentDec : "+$id.text);} methodParam |
    typeSpec arrayBrack id=IDENTIFIER {System.out.println("ArgumentDec : "+$id.text);} methodParam |
    typeSpec arrayBrack id=IDENTIFIER {System.out.println("ArgumentDec : "+$id.text);} COMMA methodParam |
    typeSpec arrayBrack id=IDENTIFIER {System.out.println("ArgumentDec : "+$id.text);} multipleAssignVarWithoutPrint methodParam |
    typeSpec arrayBrack id=IDENTIFIER {System.out.println("ArgumentDec : "+$id.text);} multipleAssignVarWithoutPrint COMMA methodParam |
;

multipleAssignVar: ASSIGN assignVar multipleAssignVar {System.out.println("Operator : =");}| ASSIGN assignVar {System.out.println("Operator : =");};

multipleAssignVarWithoutPrint: ASSIGN assignVar multipleAssignVar | ASSIGN assignVar;

// Multiple statement inside method
insideMethodMultipleStatement: print | r_returnMultiple | incr_decr_identifierMultiple | methodCallMultiple  | methodVar | methodVarAssign | conditionalStmnt | arrayDecl | loopMultipleStmnt | fptrMultiple | setDeclMult;
methodVar: varDecl insideMethodMultipleStatement|;
methodVarAssign: accessPoint multipleAssignVar insideMethodMultipleStatement |
         accessPoint multipleAssignVar insideMethodMultipleStatement;


methodCallSingle:
            //Set
            identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());}
            | SELF identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());}

            // Other
            | accessPoint LPAR {System.out.println("MethodCall");} methodCallParam RPAR ;

methodCall:
            //Set
            identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());}
            | SELF identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());}

            // Other
            | accessPoint LPAR methodCallParam RPAR;

accessPoint: (SELF identifier | identifier | INITIALIZE) pointMethodCall arrayBrack pointMethodCall;
pointMethodCall: pointMethodCall DOT accessPoint| ;

accessPoint2: (SELF identifier | identifier | INITIALIZE) a*;
a: DOT IDENTIFIER | LBRACK expression RBRACK | LPAR methodCallParam RPAR;

methodCallMultiple:
                 //Set
                identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());} insideMethodMultipleStatement
                | SELF identifier DOT (op = ADD_SET | op = MERGE | op = INCLUDE | op = DELETE) LPAR methodCallParam RPAR {System.out.println($op.text.toUpperCase());} insideMethodMultipleStatement
                // Other
                | accessPoint LPAR {System.out.println("MethodCall");} methodCallParam RPAR insideMethodMultipleStatement;

methodCallParam: (multipleAssignVar|assignVar)  COMMA methodCallParam | (multipleAssignVar|assignVar) methodCallParam |;

//Return
r_return: RETURN {System.out.println("Return");} (expression | inlineCondStmnt | assignVar);
r_returnMultiple: RETURN {System.out.println("Return");} (expression | inlineCondStmnt | assignVar) insideMethodMultipleStatement;

// Loop
loopMultipleStmnt:
      arr_interval DOT EACH {System.out.println("Loop : each");} DO VERTICAL_LINE identifier VERTICAL_LINE LBRACE insideMethodMultipleStatement RBRACE insideMethodMultipleStatement|
      arr_interval DOT EACH {System.out.println("Loop : each");} DO VERTICAL_LINE identifier VERTICAL_LINE  insideMethodSingleStatement insideMethodMultipleStatement|;
//Pre-defined functions
print: PRINT {System.out.println("Built-in : print");} LPAR (assignVar) RPAR insideMethodMultipleStatement;

// Array Declaration
arrayDeclSingle: (CLASS_ID | INT_VALUE | BOOL) arrayBrack identifier;
arrayBrack: arrayBrack LBRACK expression RBRACK | ;
arrayDecl: arrayDeclSingle insideMethodMultipleStatement;

// If, elsif, and else
conditionalStmnt
    // Signle Line
    : IF {System.out.println("Conditional : if");}  expression insideMethodSingleStatement elseIf elseStmnt insideMethodMultipleStatement|
    // Multiple Line
      IF {System.out.println("Conditional : if");} expression LBRACE insideMethodMultipleStatement RBRACE elseIf elseStmnt insideMethodMultipleStatement|
;


// Signle Statement method
insideMethodSingleStatement: printSingle | r_return | incr_decr_identifier | methodCallSingle | methodVarSingle | methodVarAssignSingle | conditionalStmntSingle  | arrayDeclSingle | loop | fptr | setDecl;
methodVarSingle: varDecl;
methodVarAssignSingle: accessPoint multipleAssignVar;

// Set Declaration
setType: SET LESS_THAN INT GREATER_THAN;
setDecl: setType identifier;
setDeclMult: setType identifier insideMethodMultipleStatement;
//Pre-defined functions
printSingle: PRINT {System.out.println("Built-in : print");} LPAR (assignVar) RPAR;

// Inline conditional statements expression ? :
insideInlineCond
    : assignVar
;
inlineCondStmnt: expression QUESTION_MARK insideInlineCond COLON insideInlineCond {System.out.println("Operator : ?:");};

// If, elsif, and else
conditionalStmntSingle
    // Signle Line
    : IF {System.out.println("Conditional : if");} expression insideMethodSingleStatement elseIf elseStmnt |
    // Multiple Line
      IF {System.out.println("Conditional : if");} expression LBRACE insideMethodMultipleStatement RBRACE elseIf elseStmnt|
;
elseIf
    : ELSIF {System.out.println("Conditional : elsif");} expression insideMethodSingleStatement elseIf|
      ELSIF {System.out.println("Conditional : elsif");} expression LBRACE insideMethodMultipleStatement RBRACE elseIf |;
elseStmnt: ELSE {System.out.println("Conditional : else");} insideMethodSingleStatement |
           ELSE {System.out.println("Conditional : else");} LBRACE insideMethodMultipleStatement RBRACE |;

// LOOP
loop
    : arr_interval DOT EACH {System.out.println("Loop : each");} DO VERTICAL_LINE expression VERTICAL_LINE LBRACE insideMethodMultipleStatement RBRACE |
      arr_interval DOT EACH {System.out.println("Loop : each");} DO VERTICAL_LINE expression VERTICAL_LINE  insideMethodSingleStatement|;

arr_interval:interval | identifier;
interval: LPAR expression DOT DOT expression RPAR;

assignVar: expression  |  inlineCondStmnt;
newClass: (CLASS_ID | (SET {System.out.println("NEW");})) DOT NEW LPAR parameterList RPAR;

parameterList
    : parameterValue COMMA parameterList | parameterValue parameterList |
    LPAR setValues RPAR parameterList
    |;
setValues: parameterValue COMMA setValues | parameterValue setValues |;
parameterValue: INT_VALUE | boolValue | identifier | SELF identifier | expression | newClass;

//Expressions(Change!)

expression: andExpression (OR andExpression {System.out.println("Operator : ||");})*;

andExpression: equalityExpression (AND equalityExpression {System.out.println("Operator : &&");})*;

equalityExpression: relationalExpression (op = (EQUAL | NOT_EQUAL) relationalExpression {System.out.println("Operator : "+$op.text);})*;

relationalExpression: additiveExpression (op = (GREATER_THAN | LESS_THAN ) additiveExpression {System.out.println("Operator : "+$op.text);})*;

additiveExpression: multiplicativeExpression (op = (MINUS | PLUS) multiplicativeExpression {System.out.println("Operator : "+$op.text);})*;

multiplicativeExpression: preUnaryExpression (op = (DIVIDE| MULT) preUnaryExpression {System.out.println("Operator : "+$op.text);})*;

preUnaryExpression: (op = (MINUS | NOT) preUnaryExpression {System.out.println("Operator : "+$op.text);}) | appendExpression ;

appendExpression: accessExpression (APPEND accessExpression)*;

accessExpression: otherExpression;

otherExpression: (INT_VALUE | boolValue) | LPAR (expression) RPAR incr_decr | methodCall |
                  newClass | incr_decr_identifier | accessPoint | accessPoint2 | methodVarAssignSingle ;


// Variables
globalVarDeclList: varDecl* |;
varDecl: (typeSpec) varDeclList | typeSpec arrayBrack varDeclList ;
varDeclList: varDeclList COMMA id=IDENTIFIER {System.out.println("VarDec : "+$id.text);} | id=IDENTIFIER {System.out.println("VarDec : "+$id.text);};
typeSpec: fptrType | CLASS_ID | setType | INT | BOOL | (fptrType | INT | BOOL | VOID | CLASS_ID | setType) arrayBrack;
methodType: fptrType | INT | BOOL | VOID | CLASS_ID | setType | (fptrType | INT | BOOL | VOID | CLASS_ID | setType) arrayBrack;
// assignVar: newClass | INT_VALUE | boolValue | expression | inlineCondStmnt ;

// fptr
fptrType: FPTR LESS_THAN typeList ARROW (typeSpec | VOID) GREATER_THAN;
fptrMultiple: fptrType identifier insideMethodMultipleStatement;
fptr: fptrType identifier;
typeList: typeSpec COMMA typeList| typeSpec;

identifier: IDENTIFIER;
incr_decr: (op=MINUS_MINUS {System.out.println("Operator : "+$op.text);} | op = PLUS_PLUS {System.out.println("Operator : "+$op.text);} |);
incr_decr_identifier:  accessPoint incr_decr | INT_VALUE incr_decr;
incr_decr_identifierMultiple:  accessPoint incr_decr insideMethodMultipleStatement | INT_VALUE incr_decr insideMethodMultipleStatement;
boolValue : TRUE | FALSE;
accessType : PUBLIC | PRIVATE ;
class_id: CLASS_ID;

testRule: IDENTIFIER;
MINUS_MINUS: '--';
PLUS_PLUS: '++';

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
SET: 'Set';
RETURN: 'return';

ADD_SET: 'add';
MERGE: 'merge';
INCLUDE: 'include';
DELETE: 'delete';


FPTR: 'fptr';
PRINT: 'print';
EACH: 'each';
DO: 'do';
VERTICAL_LINE: '|';

NEW: 'new';

SELF: 'self.';

IF: 'if';
ELSIF: 'elsif';
ELSE: 'else';

MULT: '*';
DIVIDE: '/';
PLUS: '+';
POW: '^';


MINUS: '-';

EQUAL: '==';
NOT_EQUAL: '!=';
GREATER_THAN: '>';
LESS_THAN: '<';


AND: '&&';
OR: '||';
NOT: '!';

TRUE: 'true';
FALSE: 'false';

ARROW: '->';

ASSIGN: '=';

LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

QUESTION_MARK: '?';
COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLLON: ';' -> skip;

INT: 'int';
BOOL: 'bool';
VOID: 'void';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: ('_'|[a-z_])[A-Za-z0-9_]*;
CLASS_ID: [A-Z_][A-Za-z0-9_]*;

STRING_VALUE: '"'~["]*'"';
COMMENT: ('#' ~( '\r' | '\n')*) -> skip;
COMMENT_MULTILINE: '=begin' (.)*? '=end' -> skip;
IGNORE: '\\' -> skip;

// Expressions

WS: ([ \t\n\r]) -> skip;