public class PrintPrimes {
  final int NUMBER_OF_PRIME
  final int ROWS_PER_PAGE ;
  final int COLUMNS_PER_PAGE ;
  int maxNumberOfReferencePoints;
  int listOfPrimes[];
  String test = "test";

  public PrintPrimes(int numberOfPrimes, int row, int col, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.rowPerPage  = row;
    this.columnPerPage  = col;
    this.maxNumberOfReferencePoints = ORDMAX;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      
      int numberOfPrime = 300 ;
      int rowPerPage = 50 ;
      int columnPerPage = 30 ;
      int maxNumberOfReferencePoints = 30 ;
      	
      PrintPrimes printPrimes = new PrintPrimes(numberOfPrime, rowPerPage, columnPerPage, maxNumberOfReferencePoints);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean notPrime;
      int positionOfReferencePoint;
      int listOfSquaredPrimeNumbers[] = new int[maxNumberOfReferencePoints + 1];

      int candidate = 1;
      int cursorNumber = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          candidate = candidate + 2;
          if (sampleNumber == SQUARE) {
            cursorNumber = cursorNumber + 1;
            SQUARE = listOfPrimes[cursorNumber] * listOfPrimes[cursorNumber];
            listOfSquaredPrimeNumbers[cursorNumber - 1] = candidate;
          }
          positionOfReferencePoint = 2;
          notPrime = true;
          while (positionOfReferencePoint < cursorNumber && notPrime) {
            while (listOfSquaredPrimeNumbers[N] < candidate)
              listOfSquaredPrimeNumbers[N] = listOfSquaredPrimeNumbers[positionOfReferencePoint] + listOfPrimes[positionOfReferencePoint] + listOfPrimes[positionOfReferencePoint];
            if (listOfSquaredPrimeNumbers[N] == candidate)
              notPrime = false;
            positionOfReferencePoint = positionOfReferencePoint + 1;
          }
        } while (!notPrime);
        listOfPrimes[primesFoundSoFar] = candidate;
      }
    }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          
          printPage(int pageNumber, int pageOffset);
          
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + rowPerPage * columnPerPage;
        }
    }
    
    public void printPage(int pageNumber, int pageOffset){
    	for (int rowOffset = pageOffset; rowOffset < pageOffset + rowPerPage; rowOffset++){
            for (int C = 0; C < columnPerPage;C++)
              if (rowOffset + C * rowPerPage <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + C * rowPerPage]);
            System.out.println("");
          }
    }
    	
    
}

					 
