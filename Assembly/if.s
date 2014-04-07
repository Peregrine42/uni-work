; if statements

AREA example1, CODE, READONLY

 ENTRY

start		;start
 mov R0, #7	;setup numbers
 mov R1, #10	;
 cmp R0, R1	;compare numbers
 blt addlabel	;if R0 < R1, branch
 mov R2, #15	;if not, set r2
 b   end	;jump to end

addlabel
 add R2, R0, R1	;set R2 to sum of R0 and R1
 b   end  	;jump to end

end

 END
