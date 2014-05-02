 AREA TwoMul, CODE, READONLY
 ENTRY
start
 ADR r1, data
 LDMIA r1, {r4, r5, r6}
 ADD r2, r4, r5
 STR r2, [r1]
data 
 DCD #7
 DCD #8
 DCD #9
 END