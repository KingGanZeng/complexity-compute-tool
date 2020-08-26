lexer grammar CommonLexerRules;

ID  :   [A-Z];
ATOM:   [a-z];
INT :   [0-9]+;
DOUBLE: [0-9]+'.'[0-9]+;
POW    : '^';
NL     : '\n';
WS     : [ \t\r]+ -> skip;

EQUAL   : '=';
MUL     : '*'  ;
SEQ     : ';'  ;
PARA    : '||' ;
CHO     : '#'  ;
CAL     : '@'  ;
COMMA   : ',';
LPAR    : '(';
RPAR    : ')';
LBRA    : '[';
RBRA    : ']';
NUL     : '_';
UND     : '!';
