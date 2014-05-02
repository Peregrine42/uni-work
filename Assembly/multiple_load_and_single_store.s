 AREA load_and_store, CODE, READONLY
 ENTRY
start
 ADR r1, data
 LDMIA r1, {r4, r5, r6}
 ADD r2, r4, r5
 STR r2, [r1]
data 
 DCD #12
 DCD #11
 DCD #10
 END