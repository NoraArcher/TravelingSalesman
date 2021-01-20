// Input in the command line must be "java TSshuffle <number of cities> <file with distance info>"

import java.util.*;
import java.io.*;

public class TSshuffle {

  public static void main(String[] args) {
    int N = Integer.parseInt( args[0] );
    int data[][] = matrix(N);
// Prints data.
// System.out.println( Arrays.toString(data) );
    for(int i = 0; i < data.length; i++) {
      for(int j = 0; j < data[i].length; j++) {
        System.out.print("" + data[i][j] + ", ");
      }
      System.out.println();
    }
    System.out.println( findPath(N, data) );
  }

// Creates a two-dimensional matrix to pull the length of paths between two cities later.
  public static int[][] matrix(int n) {
    int[][] arr = new int[n][n];
    int i = 0;
    int j = 0;
    Scanner in = new Scanner( System.in );
    while( in.hasNext() && i < 8) {
      Scanner line = new Scanner( in.nextLine() );
      j = 0;
      while( line.hasNext() && j < 8) {
        // Adds 0 to the matrix if the path has already been covered or if it's mapping the city to itself.
        if (j <= i) {
          arr[i][j] = 0;
        }
        // Adds the length of the path to the matrix.
        else {
          while( line.hasNext() ) {
            String next = line.next();
            if ( isNumber( next ) ) arr[i][j] = Integer.parseInt(next);
          }
        }
        j++;
      }
      i++;
    }
    return arr;
  }

// Checks if word is a number. Credits to Ryan for this.
  public static boolean isNumber(String word) {
    if (word == null) return false;
    try{
      int num = Integer.parseInt(word);
    }
    catch(NumberFormatException e){
      return false;
    }
    return true;
  }

  public static int findPath(int n, int[][] data) {
    int N = n;
    int best = 1000000;
    int t = 0;
    for(int a = 0; a < N; a++) {
      t = 0;
      for(int b = 0; a < b && b < N; b++) {
        t += data[a][b];
        for(int c = 0; b < c && c < N; c++) {
          t += data[b][c];
          for(int d = 0; c < d && d < N; d++) {
            t += data[c][d];
            for(int e = 0; d < e && e < N; e++) {
              t += data[d][e];
              for(int f = 0; e < f && f < N; f++) {
                t += data[e][f];
                for(int g = 0; f < g && g < N; g++) {
                  t += data[f][g];
                  for(int h = 0; g < h && h < N; h++) {
                    t += data[g][h];
                    if (t < best) best = t;
                    t = 0;
                  }
                }
              }
            }
          }
        }
      }
    }
    return best;
  }

}
