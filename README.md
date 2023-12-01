
Add a sample inventory

BootStrapData.java ln35-75: added sample individual fishing parts/gear, I made sure to add a if statement that checks to see whether the partsRepository is == 0, before adding the parts so no duplicate data is added each time app runs.
BootStrapData.java ln96-105: added sample fishing products/combos, I made sure to add a if statement that checks to see whether the productsRepository is == 0, before adding the products so no duplicate data is added each time app runs.






Tracking  maximum and minimum inventory

Part.java ln31-35: added minInventory and maxInventory instance variables, created new constructor to accept these new variables ln 43, created getters/setters ln 53,57.
BootStrapData.java ln42-43: added minInventory and Max inventory to each sample part.
InvRange.java ln11-17: created InvRange annotation set target to TYPE and Annotation TYPE and Retention to RUNTIME, this will allow me to pass the entire parts class for validation check.
IsInvValid.java 17-21:created method to check for validation for inventory value to be in between min and max values.
Part.java ln24: added @InvRange annotation so I can use reflection to access getters in the IsInvValid method to validate true or false.


Added validation

AddInhousePartController.java ln44-52: updated if statement in the  submitForm method to be more specific on whether a part inv is in between the min and mx values depending on the boolean result,
it will direct the user to max-error.html or min-error.html.
AddOutsourcedPartController.java ln44-52: I did the same thing as above on AddInhousePartController's sumbitForm method.
max-error.html ln8-19: added message that alerts user that inventory amount is too high and gives them an option link to return to the Add in-house/out-sourced parts form.
min-error.html ln8-18: added message that alerts user that inventory amount is too low and gives them an option link to return to the Add in-house/out-sourced parts form.
EnufPartsValidator.java ln36: added "or" binary operator to check if the inventory for the part would be less than inventory min if part was added (p.getInv-1)<(p.getMin).
ValidEnufParts.java ln20: updated error message to reflect that if the part was added it would drop the inventory level of the part below the inventory minimum.



PartTest.java ln98-104: added test for the method setMinInventory.
PartTest.java ln106-112: added test for the method setMaxInventory.
