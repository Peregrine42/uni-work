 AREA Multiply, CODE, READONLY	; name
 ENTRY ; marker of 1st executable instruction
start		; label
 MOV r0, #0	; counter
 MOV r1, #1	; first number
 MOV r2, #3	; second number
 MOV r3, #0	; total

loop		; label indicating start of loop
 ADD r3, r1, r3 ; add r1 to total
 ADD r0, r0, #1	; add one to counter
 CMP r0, r2	; compare counter with second number
 BNE loop
 END