 AREA Triangle, CODE, READONLY		; name
 ENTRY ; marker of 1st executable instruction
start			; label
 MOV r1, #8		; put the width into the register 1
 MOV r2, #4		; put the height into the register 2
 MUL r0, r1, r2		; multiply r1 and r2
 MOV r0, r0, ASR #1	; divide by 2
 END