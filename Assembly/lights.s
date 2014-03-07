 AREA Triangle, CODE, READONLY		; name
 ENTRY ; marker of 1st executable instruction

start			; label
 SWI #h00f00004		; read value from slider
 MOV r1, r0
 MVN r0, r1		; invert
 SWI #h00f00005		; output to lights
 END