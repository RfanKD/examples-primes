public class PrintPrimes {
  final int numberOfPrimes;
  final int rowPerPage;
  final int columnPerPage;
  int WW;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int row, int col, int WW, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.rowPerPage  = row;
    this.columnPerPage  = col;
    this.WW  = WW;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 10, 30);
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
      int N;
      int MULT[] = new int[ORDMAX + 1];

      int candidate = 1;
      int ORD = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          candidate = candidate + 2;
          if (sampleNumber == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = candidate;
          }
          N = 2;
          notPrime = true;
          while (N < ORD && notPrime) {
            while (MULT[N] < candidate)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == candidate)
              notPrime = false;
            N = N + 1;
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
          for (int rowOffset = pageOffset; rowOffset < pageOffset + rowPerPage; rowOffset++){
            for (int C = 0; C < columnPerPage;C++)
              if (rowOffset + C * rowPerPage <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + C * rowPerPage]);
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + rowPerPage * columnPerPage;
        }
    }
}

					 
