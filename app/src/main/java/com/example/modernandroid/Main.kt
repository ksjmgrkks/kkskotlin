package com.example.modernandroid

fun main() {
    var x = 10 // int 형 변수
    var str = "Hello"
    var isMarried = true

    var a: Int = 10
    // int, float, double ...
    // Int, Float, Double

    val b = 10
    // var는 변수여서 변경할 수 있지만, val은 상수여서 한번 선언하면 변경할 수 없다.

    print("$str World")
    // 코틀린에서 문자를 합치는 방법 -> ""안에 다 집어넣고, 변수 앞에다 $만 붙여주면 됨!

    print(myMethod(10,20))
    print(myMethod2(10,20))
    print(myMethod3(10,20))

    //코틀린은 자바보다 오류를 줄이는데 좋으므로 var(변수) 보다는 웬만하면 val(상수) 로 정의하는게 좋다.
    val items = listOf(1,2,3,4,5) // 불변
    val items2 = arrayListOf(1,2,3,4,5) // 변경 가능

    items2.add(7)
    items2.remove(1)

    items2[0] = 10

    print(items)
    print(items2)

    //조건문
    val y = 2
    if(y % 2 == 0){
       print("짝")
    }

    val isEven = if (y % 2 == 0) "짝" else "홀"
    // y가 2로 나눈 나머지가 0일 때 "짝"을 isEven 에 대입하고, 그 외는 "홀"을 isEven 에 대입하는 '조건식'

    // 반복문
    val numbers = listOf(1,2,3,4,5)
    for(i in numbers){
        println(i)
    }

    for(i in 0..9){
        println(i)
    }

    // switch 문 대신에 쓰는 when 문 return 하는 값이 있다면
    // val y = when (x){} 이런식으로 앞의 변수에 대입할 수도 있다.

    var z = 1

    when(z){
        1 -> print("1입니다.")
        2 -> print("2입니다.")
        3,4,5 -> print("3이나 4나 5입니다.")
        in 6..20 -> print("6부터 20 사이의 값입니다.")
        !in 8..10 -> print("8~10이 아닐 때")
        else -> print("그 외 else")

    }

    //자바에서는 Person person = new Person(); 이었다면 코틀린은 아래와 같이 쓴다.
    val person = Person("김규성")

    // 자바에서는 게터 세터 생성자 만들어서 person.getName() 이런식으로 클래스의 변수를 가져왔다면
    // 코틀린에서는 이런식으로 가져온다.
    print(person.name)

    val person2 = Person2("김규성", 27)
    print(person)

}

fun myMethod(a: Int, b: Int): Int{
    return a+b
}
fun myMethod2(a: Int, b: Int): Int = a+b
fun myMethod3(a: Int, b: Int) = a+b
// 한줄로 처리하는 메소드는 위와 같이 쓸 수도 있다.
// return 타입이 없은 메소드의 타입은 자바에서는 void 였지만, 코틀린에서는 Unit 타입이라고 하고 보통 생략한다.
fun unitMethod(a: Int, b: Int): Unit {
    print(a+b)
}
fun unitMethod2(a: Int, b: Int) {
    print(a+b)
}
class Person(var name: String){
    init {
        // init 은 생성자 역할을 하는 메소드다! 생성자보다 먼저 실행됨
        print("나의 이름: $name")
    }

}

// data class 는 게터 세터 만들 필요없이 이렇게만 써주면 끝!
data class Person2(
    val name: String,
    var age: Int
)

//코틀린에는 확장 함수가 있어서 기존 클래스에 함수(메소드)를 추가할 수 있다. 핵심 기능임
// 예시 기존 String 클래스에 myLength 라는 함수를 새로 정의하여 사용하고 있다.
fun String.myLength(): Int {
    return this.length
}
