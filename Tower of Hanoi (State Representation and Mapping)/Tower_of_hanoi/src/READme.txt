This how I printed the solution.

3 Largest disk
2 Larger disk
1 Smallest dist


Stick position :
<1st Stick>|<2nd Stick>|<3rd Stick>


Initial state: 321||                                     /* object.toString() */
Initial state: 321|<empty>|<empty>

Intermediate states:

32||1
3|2|1
3|21|
|21|3
1|2|3
1||32
.....
.....

Final state: ||321                                       /* object.toString() */
Final state: <empty>|<empty>|321
