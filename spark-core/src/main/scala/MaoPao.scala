object MaoPao {
  def main(args: Array[String]): Unit = {

    var a=Array(12,6,8,4,10,7,1,5,3,9,2)
    println("---------排序前---------")
    a.foreach(println)
    for (i<- 0 until a.length-1){
      //遍历没有排好序的数
      for (j<-0 until a.length-1-i) {
        //如果前面的比后面的数大
        if(a(j)>a(j+1)){
          //交换
          var tmp=a(j)
          a(j)=a(j+1)
          a(j+1)=tmp
        }
      }
//      println("####第"+(i+1)+"次排序####")
//      a.foreach(println)
    }
    println("---------排序后---------")
    a.foreach(println)
  }
}
