object CharacterTree {
  def print_tree_char(height: Int, char:Char): Unit = {
    // TODO: This function should print out the standard character tree
    val startSpaces:Int = height-1
    var numSpaces:Int = startSpaces
    var numSym:Int = 1;
    for(i <- 0 until height){
      for(sp <- 0 until numSpaces){
        printf(" ")
      }
      for(sy <- 0 until numSym){
        printf("%c", char)
      }
      numSpaces-=1
      numSym+=2
      printf("\n")
    }
    for(lsp <- 0 until startSpaces){
      printf(" ")
    }
    printf("*\n\n")
  }

  def print_tree(height: Int): Unit = {
    print_tree_char(height, '*')
  }

  def main(args: Array[String]): Unit = {
    var foo: Int = 5
    print_tree(foo)
    print_tree_char(foo, 'o');
  }
}