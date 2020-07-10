**Vending Machine 2.0**

**Implementation**

   * Move VendingMachine-2.0.jar and ItemList.txt into the same directory.
   * To execute open bash shell type cd \yourworkingdirectory  
     *  (yourworkingdirectory is location where you stored jar and txt files).
   * Type **java -cp ./VendingMachine-2.0.jar App**

**Rolling back**

To roll back to version 1.0, move VendingMachine-1.0.jar to previously mentioned directory (yourdirectory) and invoke the same bash command you did before but replace 2.0 with 1.0:  
   *  **java -cp ./VendingMachine-1.0.jar App**
  
If ItemList.txt is lost, create a new ItemList.txt file in the same directory (yourdirectory).

**Release notes**

What’s new

   *	Implemented spring DI  
   *	There is no functional change
    
Bug Fixes

   *	Internal bug fixes  
   *	Fixed tests


