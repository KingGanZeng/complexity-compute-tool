grammar LibExpr;
import CommonLexerRules;

prog
    :   input+
    ;

input
    :   setVar                 # ToSetVar
    |   calculateExpr NL       # Calculate
    ;

setVar
    :   ID EQUAL calculateExpr NL       # SetVarible
    |   ID EQUAL LBRA getAtom RBRA NL   # SetVaribleBRA
    |   ATOM EQUAL calculateExpr NL     # SetAtom
    ;

getAtom
    :   ATOM COMMA atom       # SetAtomVal
    |   DOUBLE COMMA atom     # SetVarVal
    ;

calculateExpr
    :   INT MUL atom                          # Multiplication
    |   calculateExpr SEQ callOrchoice        # Sequential
    |   calculateExpr PARA atom callOrchoice  # Paralle
    |   callOrchoice                          # ToCallOrchoice
    ;

callOrchoice
    :   callOrchoice CAL atom next     # Call
    |   callOrchoice CHO atom next     # Choice
    |   next                           # ToNext
    ;

next
    :   MUL next     # ChangeSign
    |   atom         # ToAtom
    ;

atom
    :   DOUBLE                          # Double
    |   INT                             # Int
    |   ID                              # Variable
    |   ATOM                            # AtomVar
    |   LPAR calculateExpr RPAR         # Braces
    ;