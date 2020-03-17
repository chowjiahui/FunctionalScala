package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ((c == 0 && r == 0) || c == 0 || c == r) 1
      else pascal(c, r-1) + pascal(c-1, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def iterate(chars: List[Char], acc: Int=0): Int = {
        if (acc < 0 || chars.isEmpty) acc
        else if (chars.head == '(') iterate(chars.tail, acc + 2)
        else if (chars.head == ')') iterate(chars.tail, acc - 2)
        else iterate(chars.tail, acc)
      }

      iterate(chars, 0) != -2
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money > 0 && coins.nonEmpty){
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      }
      else 0
    }
  }

object CurryExercise {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a+1, b)
  }
  def factorial(n: Int): Int = product(x => x)(1, n)

}

object FixedPointExercise {
  def sqrt()
}
