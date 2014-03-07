 AREA Triangle, CODE, READONLY		; name
 ENTRY ; marker of 1st executable instruction

start			; label
 SWI #h00f00004		; get number and store in r0
 MOV r1, r0		; move input number to max

loop			; begin loop
 SWI #h00f00004		; get number and store in r0
 CMP r0, r1		; if input is higher than max
 MOVHI r1, r0		; move input to max

 CMP r0, #0		; if input is 0
 BNE loop		; jump back to loop
 END