grammar arithmetics;

S
    : (A EQQ | E);
E
    : (E PLUS E | E MULT E | OPEN E CLOSE | ID | INT);
A
    : (ID EQUAL E);

EQQ: ';';
PLUS: '+';
MULT: '*';
OPEN: '(';
CLOSE: ')';
ID: [a-zA-Z] [a-zA-Z_0-9]*;
INT: [1-9] [0-9]*;
EQUAL: '=';