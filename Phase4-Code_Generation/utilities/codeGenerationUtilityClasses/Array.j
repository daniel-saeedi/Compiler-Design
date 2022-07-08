.class public Array
.super java/lang/Object

.field public elements Ljava/util/ArrayList;
  .signature "Ljava/util/ArrayList<Ljava/lang/Object;>;"
  .end field

.method public <init>(Ljava/util/ArrayList;)V
  .limit stack 3
  .limit locals 4
  .var 0 is this LArray; from Label0 to Label52
  .var 1 is newElements Ljava/util/ArrayList; signature "Ljava/util/ArrayList<Ljava/lang/Object;>;" from Label0 to Label52
  .var 3 is newElement Ljava/lang/Object; from Label36 to Label49
Label0:
  .line 9
  0: aload_0
  1: invokespecial java/lang/Object/<init>()V
  .line 10
  4: aload_0
  5: new java/util/ArrayList
  8: dup
  9: invokespecial java/util/ArrayList/<init>()V
  12: putfield Array/elements Ljava/util/ArrayList;
  .line 11
  15: aload_1
  16: invokevirtual java/util/ArrayList/iterator()Ljava/util/Iterator;
  19: astore_2
Label20:
  20: aload_2
  21: invokeinterface java/util/Iterator/hasNext()Z 1
  26: ifeq Label52
  29: aload_2
  30: invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
  35: astore_3
Label36:
  .line 12
  36: aload_0
  37: getfield Array/elements Ljava/util/ArrayList;
  40: aload_0
  41: aload_3
  42: invokevirtual Array/getNewObject(Ljava/lang/Object;)Ljava/lang/Object;
  45: invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
  48: pop
Label49:
  49: goto Label20
Label52:
  .line 13
  52: return
  ; full_frame (frameNumber = 0)
  ; frame_type = 255, offset_delta = 20
  ; frame bytes: 255 0 20 0 3 7 0 11 7 0 7 7 0 21 0 0
  .stack
    offset 20
    locals Object Array
    locals Object java/util/ArrayList
    locals Object java/util/Iterator
    .end stack
  ; chop_frame (frameNumber = 1)
  ; frame_type = 250, offset_delta = 31
  ; frame bytes: 250 0 31
  .stack
    offset 52
    locals Object Array
    locals Object java/util/ArrayList
    .end stack
  .signature "(Ljava/util/ArrayList<Ljava/lang/Object;>;)V"
.end method

.method public <init>(ILjava/lang/Object;)V
  .limit stack 4
  .limit locals 4
  .var 0 is this LArray; from Label0 to Label42
  .var 1 is size I from Label0 to Label42
  .var 2 is defaultElement Ljava/lang/Object; from Label0 to Label42
  .var 3 is i I from Label18 to Label42
Label0:
  .line 15
  0: aload_0
  1: invokespecial java/lang/Object/<init>()V
  .line 16
  4: aload_0
  5: new java/util/ArrayList
  8: dup
  9: iload_1
  10: invokespecial java/util/ArrayList/<init>(I)V
  13: putfield Array/elements Ljava/util/ArrayList;
  .line 17
  16: iconst_0
  17: istore_3
Label18:
  18: iload_3
  19: iload_1
  20: if_icmpge Label42
  .line 18
  23: aload_0
  24: getfield Array/elements Ljava/util/ArrayList;
  27: aload_0
  28: aload_2
  29: invokevirtual Array/getNewObject(Ljava/lang/Object;)Ljava/lang/Object;
  32: invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
  35: pop
  .line 17
  36: iinc 3 1
  39: goto Label18
Label42:
  .line 20
  42: return
  ; full_frame (frameNumber = 0)
  ; frame_type = 255, offset_delta = 18
  ; frame bytes: 255 0 18 0 4 7 0 11 1 7 0 2 1 0 0
  .stack
    offset 18
    locals Object Array
    locals Integer
    locals Object java/lang/Object
    locals Integer
    .end stack
  ; chop_frame (frameNumber = 1)
  ; frame_type = 250, offset_delta = 23
  ; frame bytes: 250 0 23
  .stack
    offset 42
    locals Object Array
    locals Integer
    locals Object java/lang/Object
    .end stack
.end method

.method public <init>(II)V
  .limit stack 5
  .limit locals 3
  .var 0 is this LArray; from Label0 to Label28
  .var 1 is leftVal I from Label0 to Label28
  .var 2 is rightVal I from Label0 to Label28
Label0:
  .line 22
  0: aload_0
  1: invokespecial java/lang/Object/<init>()V
  .line 23
  4: aload_0
  5: new java/util/ArrayList
  8: dup
  9: iload_1
  10: iload_2
  11: invokestatic java/util/stream/IntStream/rangeClosed(II)Ljava/util/stream/IntStream;
  14: invokeinterface java/util/stream/IntStream/toArray()[I 1
  19: invokestatic java/util/List/of(Ljava/lang/Object;)Ljava/util/List;
  22: invokespecial java/util/ArrayList/<init>(Ljava/util/Collection;)V
  25: putfield Array/elements Ljava/util/ArrayList;
Label28:
  .line 24
  28: return
.end method

.method public <init>(LArray;)V
  .limit stack 2
  .limit locals 2
  .var 0 is this LArray; from Label0 to Label8
  .var 1 is that LArray; from Label0 to Label8
Label0:
  .line 27
  0: aload_0
  1: aload_1
  2: getfield Array/elements Ljava/util/ArrayList;
  5: invokespecial Array/<init>(Ljava/util/ArrayList;)V
Label8:
  .line 28
  8: return
.end method

.method private getNewObject(Ljava/lang/Object;)Ljava/lang/Object;
  .limit stack 3
  .limit locals 2
  .var 0 is this LArray; from Label0 to Label20
  .var 1 is o Ljava/lang/Object; from Label0 to Label20
Label0:
  .line 31
  0: aload_1
  1: instanceof Array
  4: ifeq Label19
  .line 32
  7: new Array
  10: dup
  11: aload_1
  12: checkcast Array
  15: invokespecial Array/<init>(LArray;)V
  18: areturn
Label19:
  .line 34
  19: aload_1
Label20:
  20: areturn
  ; same_frame (frameNumber = 0)
  ; frame_type = 19, offset_delta = 19
  ; frame bytes: 19
  .stack
    offset 19
    .end stack
.end method

.method public getElement(I)Ljava/lang/Object;
  .limit stack 2
  .limit locals 2
  .var 0 is this LArray; from Label0 to Label8
  .var 1 is index I from Label0 to Label8
Label0:
  .line 38
  0: aload_0
  1: getfield Array/elements Ljava/util/ArrayList;
  4: iload_1
  5: invokevirtual java/util/ArrayList/get(I)Ljava/lang/Object;
Label8:
  8: areturn
.end method

.method public setElement(ILjava/lang/Object;)V
  .limit stack 3
  .limit locals 3
  .var 0 is this LArray; from Label0 to Label10
  .var 1 is index I from Label0 to Label10
  .var 2 is value Ljava/lang/Object; from Label0 to Label10
Label0:
  .line 42
  0: aload_0
  1: getfield Array/elements Ljava/util/ArrayList;
  4: iload_1
  5: aload_2
  6: invokevirtual java/util/ArrayList/set(ILjava/lang/Object;)Ljava/lang/Object;
  9: pop
Label10:
  .line 43
  10: return
.end method

.method public getSize()I
  .limit stack 1
  .limit locals 1
  .var 0 is this LArray; from Label0 to Label7
Label0:
  .line 45
  0: aload_0
  1: getfield Array/elements Ljava/util/ArrayList;
  4: invokevirtual java/util/ArrayList/size()I
Label7:
  7: ireturn
.end method


