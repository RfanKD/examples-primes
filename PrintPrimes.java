public class PrintPrimes {
  int M;
  int RR;
  int CC;
  int WW;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int M, int RR, int CC, int WW, int ORDMAX) {
    this.M   = M;
    this.RR  = RR;
    this.CC  = CC;
    this.WW  = WW;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[M + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 10, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      boolean JPRIME;
      int N;
      int MULT[] = new int[ORDMAX + 1];

      int J = 1;
      int K = 1;
      listOfPrimes[1] = 2;
      int ORD = 2;
      int SQUARE = 9;

      while (K < M) {
        do {
          J = J + 2;
          if (J == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = J;
          }
          N = 2;
          JPRIME = true;
          while (N < ORD && JPRIME) {
            while (MULT[N] < J)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == J)
              JPRIME = false;
            N = N + 1;
          }
        } while (!JPRIME);
        K = K + 1;
        listOfPrimes[K] = J;
      }
    }

    public void printPrimes() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
          System.out.println("The First " + M +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++){
            for (int C = 0; C < CC;C++)
              if (ROWOFFSET + C * RR <= M)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * RR]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + RR * CC;
        }
    }
}

					 
