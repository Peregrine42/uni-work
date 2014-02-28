 AREA Example, CODE, READONLY	; name
 ENTRY ; marker of 1st executable instruction
start		; label
 MOV r0, #11	; put the value 11 in register 0
 MOV r1, #31	; puts the value 31 in register 1
 MOV r2, #1	; puts the value 1 in register 2
 ADD r0, r0, r1	; r0 = r0 + r1
 ADD r0, r0, r2	; r0 = r0 + r2
 END		; marks the end of the file