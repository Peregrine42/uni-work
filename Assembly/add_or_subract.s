 AREA Add_OR_Subract, CODE, READONLY	; name
 ENTRY ; marker of 1st execuatable instruction
start		; label
 MOV r0, #0	; the register that determines whether we add or subtract
 MOV r1, #2	; first register
 MOV r2, #2	; second register

 CMP r0, #1	; compare determiner to 1
 BNE subtract	; if determiner was 1, keep going, if 0 jump to subtract
 ADD r1, r1, r2	; add r1 to r2
finished	; label for coming back from subtract
END

subtract	; label
 SUB r1, r1, r2	; subtract r1 to r2
 B finished	; go back to finished