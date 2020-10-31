# coursera_kotlin

Kotlin In Action 의 저자가 가르키는 코틀린 중급 문법 및 과제 , 실습을 다룬다.



### Functions

>Kotlin에서는 함수를 Block body, Expression body 중 선택하여 정의할 수 있다.
>
>Kotlin에서 top-level (클래스 외부)에 정의한 함수의 경우 static 함수로 정의되어 있다.

### Named & default arguments

>Named Arguments를 통해 코드의 가독성과 명시성을 높일 수 있으며
>
>parameter를 정의된 것과 다른 순서로 쓰는 것이 가능하다.
>
>이 기능을 Java 코드에서도 사용하고자 할 경우 함수 위에 `@JvmOverloads` 어노테이션을 붙여줘야 한다.

#### Conditionals : if & when

>Java에서는 모든 제어문 (ex: 조건문, 반복문)이 statement이지만, Kotlin에서는 반복문만 제외하고는 모두 Expression이다.
>
>kotlin에서는 swich문을 대신할 when을 사용하며 각 항목에 break;를 하지않아도 된다.
>
>또 한 비교연산자 외에도 형 변환 검사를 하는 is를 통해 타입체크가 가능하다.

### Loops/ ‘in’ checks & ranges

>- Kotlin의 for 문에서 list, map, string을 iterate 할 수 있다. list의 경우 `withIndex()`라는 함수를 통
>
>  해 iterate시에 index값을 사용할 수 있다.
>
>- `..`, `until`, `downTo`, `step`등을 통해 특정 구간을 다양한 방식으로 iterate 할 수 있다.

###  Extension Functions/Examples from the Standard Library

>Kotlin에서 기본적으로 제공하는 대부분의 유용한 함수는 모두 Java의 Class에 대한 Extension (확장함수) 형태로 구현된 것이다. 
>
>예시 : List (`joinToString()`, `getOrNull()`, `withIndex()`), Char (`isLetter()`, `isLetterOrDigit()`)
>
>String (`trimMargin()`, `trimIndent()`, `toRegex()`)
>
> Conversion to numbers (`toInt()`, `toDouble()`, `toIntOrNull()`

#### Calling Extensions

>- Top-level에서 함수를 정의할 경우 Static으로 정의됩니다. 이에 따라 Top-level로 정의된 확장함수는 Static 메소드와 동일한 적용 범위를 가집니다. 
>
>  (관련 링크 : [Kotlin의 Extension은 어떻게 동작하는가 part 1](https://link.medium.com/4tvwpeXuBT))
>
>- 한편 클래스 내부에 멤버 메소드 형태로 확장함수를 정의하는 경우 1) 해당 클래스 내부 멤버 메소드/필드, 2) 해당 클래스 확장함수, 3) Lambda with Recevier 파트에서 배우는 `with` 함수를 통한 접근시에만 접근이 가능하다.

#### Importance of extensions

>Java의 기본 Class 또는 외부 라이브러리에서 제공하는 Class에 대해 고유한 기능으로 동작하는 함수를 추가적으로 정의해야 할 경우 확장함수 형태로 정의하는 것이 권장된다.
>
>해당 Class를 작성했을 때 자동완성 형태로 보여지므로 빠르게 사용할 수 있고, 다른 개발자가 해당 Class에 대해 보다 명확하게 이해하는 데에도 도움을 줄 수 있다.

#### Nullable types

>NPE를 처리하기 위해서는 조건문을 사용하여 명시적으로 null 여부를 체크하거나 
>
>(ex: `if(variable != null) { }`), Safe access expression(`?`)을 쓰거나, Not-null assertion(`!!`)을 사용해야 한다.
>
>한편 조건문을 통해 null 체크한 뒤에 컴파일 에러가 발생하지 않는 것은 smart casts 에 따라 자동으로
>
>Non-nullable로 형변환되기 때문이다.
>
>Safe access expression(`?`)을 쓸 경우 역참조하는 변수가 null인 경우 null을 반환한다. 
>
>이에 대한 디폴트값을 주기 위해서는 Elvis operator(`?:`)를 사용한다. 
>
>Elvis operator는 Groovy 언어에서 영감을 받아 차용된 된 개념이다.
>
>Elvis operator(`?:`)는 Kotlin 연산자 우선순위(Operator precedence)에 따라 동작하므로 다른 연산자와 함께 사용할 때 주의해야 한다.
>
>```kotlin
>val x: Int? = 1
>val y: Int = 2
>val sum = x ?: 0 + y
>println(sum)  // + 연산자가 우선순위가 높기 때문에 (0+y)값 계산이 먼저 된다. 
>//따라서 답은 1이 나온다. 
>```
>
>Not-null assertion(`!!`)의 경우 개발자가 논리적으로 절대 null이 발생할 가능성이 없다고 확신할 때를 제외하면 가능한 피하는 것이 좋다. (먼저 if문으로 null값인지 확인 필요 )
>
> 이는 결국 기존 Java의 문제점인 Run-time 상에서의 NPE를 허용하는 것이기 때문이다. 
>
>하지만 그럼에도 Not-null assertion(`!!`) 이 좋은 것은 Java에 비해 가독성 측면에서 NPE가 발생할 가능성이 있는 지점을 명시적으로 보여주기 때문이다.
>
>Kotlin은 Int, Char, Boolean 등에 대해 Primitive Type과 Wrapper class(Reference Type)를 구분하지 않는
>
>다. Java처럼 `int`와 `Integer`를 구분하지 않으며 오직 `Int`만 가지고 컴파일시에 자동으로 상황에 맞게 
>
>Primitive Type 또는 Wrapper class로 변환한다. 한편, Java에서 Primitive Type은 Null을 가질 수 없으므로 
>
>`Int?`와 같이 Nullable 타입으로 지정하는 경우 컴파일시에 무조건 Wrapper Class로 변환된다.

#### Nullable types under the hood

>Kotlin에서 Nullable type과 Non-nullable type은 Java8에서 도입된 Optional 클래스가 아니라, 
>
>RetentionPolicy.CLASS (런타임시 적용되지 않음)인 Java annotation 형태로 (`@Nullable`,`@NotNull`) 변환되어 적용된다. 
>
>이에 따라 성능 오버헤드가 발생하지 않으며 Null 문제를 해결할 수 있다는 장점이 있다.
>
>- `List<Int?>`는 non-nullable list of nullable values 이고, `List<Int>?`는 nullable list of non-nullable values 이다.
>
>isEmptyOrNull()를 사용할때 앞의 객체에 대해 nullable를 하지 않아도 되는 것이 함수에서 처리해주기 때문 하지만 혼동을 주는것을 방지해야 한다.

#### Checking whether string is null or empty

>- Extension을 정의하는 String은 nullable일까 non-nullable일까? ->nullable

#### Safe casts  & Safe casts

>- Unsafe casts (as) : `as` 키워드는 Type casting 시에 사용되며 캐스팅하려는 변수가 null 또는 다른 타입
>
>  인 경우 컴파일 오류는 발생하지 않지만 런타임시에 ClassCastException이 발생한다.
>
>- Safe casts (as?) : `as?` 키워드는 캐스팅하려는 변수가 null 또는 다른 타입인 경우 null이 반환되며 런타임 오류가 발생하지 않는다.
>
>```kotlin
>val s= if( a is String) a else null
>-> 
>val s: String? = any as? String
>```
>
>```kotlin
>val s="abc"
>    println(s as? Int)
>    println(s as Int?)
>```
>
>위에서의 println 2개의 차이점은  unsafe casts ,Safe casts 의 차이점을 보여준다. 
>
>```kotlin
>val s:Int = 1
>println(s as Int?)
>```
>
>- 위와 같이 s에 대해 명시적으로 Non-nullable Int로 타입을 지정해주더라도 `s as Int?`는 런타임시에 null을 반환하지 않고 동일한 타입으로 인식한다. 
>- Option(옵션)을 사용하면 이런 방식으로 작동하지 않는다.
>- Optional Class와 annotation 방식의 차이라고 보며 코틀린은 여러가지 타입조작이 용이하다.
>- Kotlin은 Nullable/Non-nullable type, 몇 개의 Operator (`?`, `?:`, `!!`, `as?`), smart casts 등 몇가지 기능을 통해 Nullability 문제를 효과적으로 다룰 수 있도록 설계 되었다.
>- Java8에서 도입된 Optional 방식에 비해 Kotlin 방식이 좋은 점은 앞서 언급한 성능 오버헤드 이슈 외에도, 런타임시에 Nullable type과 Non-nullable type이 동일하게 동작하여 변수 할당에 있어 유연하다는 점이다.

#### Lambdas

>Lambda는 인자(argument)를 반환하는 익명함수 이다.
>
>익명함수란 함수명이 없는 함수로 `fun(x:Int):Int = x+1` 형태로 직접 작성할 수 도 있고, Lambda 형태로 작성할 수 도 있습니다.
>
>- Lambda를 사용할 때 아래와 같이 코드를 간소활 수 있습니다.
>
>```kotlin
>//1. 기본 형태 (Lambda expression을 mapValues 확장함수의 인자로 받음)
>pairList.filter({ i:Employee? -> i?.city == "PRAGUE" })
>
>//2. Lambda를 괄호 뒤에 씀 
>employees.filter() { i:Employee? -> i?.city == "PRAGUE" }
>
>//3. 괄호가 비는 경우 괄호 생략 (Groovy 에서 고안하여 검증되었고 차용한 아이디어)
>employees.filter { i:Employee? -> i?.city == "PRAGUE" }
>
>//4. Lambda의 인자 타입 생략 
>employees.filter { i -> i?.city == "PRAGUE" }
>
>//5. Lambda의 인자가 1개인 경우 인자 생략하고 it으로 처리 
>employees.filter { it?.city == "PRAGUE" }
>
>//번외 멀티라인 람다: 마지막 표현식을 반환한다. 
>list.any{println("processing")
>        it >0 
>}
>```
>
>- Lambda가 인자로 Map.Entry나 Pair를 받는 경우 아래와 같이 코드를 간소화할 수 있습니다.
>
>```kotlin
>//1. 기본 형태 
>map.mapValues { entry -> "${entry.value}!"}
>
>//2. Destructuring syntax (인자를 Pair 형태로 명시하여 바로 value 접근 가능)
>map.mapValues { (key, value) -> "$value!"}
>
>//3. 사용되지 않는 인자를 "_" 처리하여 사용되지 않음을 명시 & 네이밍 고민안해도 됨
>map.mapValues { (_, value) -> "$value!" }
>```

#### Common Operations on a collections

>**filter / partition / count**
>
>- filter : Lambda로 정의된 predicate를 만족하는 원소들로 구성된 Collection을 반환하며 만족하는 원소가 없다면 null을 반환.
>
>- map: Lambda로 정의된 식으로 원소들을 람다식에 맞는 값으로 반환
>
>- any , all,none: 람다식에 해당하는 값이 하나라도 있으면 모든 원소가 만족, 모든 원소가 불만족 일때  true 값 반환
>
>- find, first, firstOrNull : 람다식에 해당하는 값 반환 , 첫번째 값 반환 , 만족하는게 없으면 null 반환 
>
>  last,lastOrNull : 해당하는 마지막값 반환, 없으면 null 반환 
>
>- partition : Lambda로 정의된 predicate를 만족하는 원소들과, 만족하지 않는 원소들로 나누어 Pair of Collectoins를 반환. 상황에 따라 만족하지 않는 원소들도 필요한 경우 filter 대신 partition 사용.
>
>  ```kotlin
>  val (youngest, oldest) = heroes.partition { it.age < 30 }
>  ```
>
>  
>
>- count: Lambda로 정의된 predicate를 만족하는 원소 개수를 반환.
>
>- groupBy : 람다식에 해당하는 값을 기준으로 원소나누어 Pair of Collectoins를 반환.
>
>  associateBY는 람다식 결과값이 같은 중복값을 제거하고 Pair of Collections 값 반환  즉 unique 하지 않을 경우 가장 마지막 원소를 제외하고 지워짐.
>
>- predicate : boolean test(T) 메소드가 정의된 인터페이스로 T 타입 데이터에 대한 특정 조건 부합 여부를 확인하여 bool을 반환
>
>- distinct : 컬렉션에서 중복되는 원소를 제거하고 unique한 원소들만으로 구성된 Collection 으로 반환

#### Operations Quiz 

>- Map에서 key에 해당되는 value를 조회할 때 `map["key"]` 는 해당 key가 없는 경우 null을 반환하며, 
>
>  map.getValue("key")` 는 해당 key가 없는 경우 NoSuchElementException을 반환하고, 
>
>  map.getOrElse("key") { }` 는 해당 key가 없는 경우 lambda로 정의된 argument를 디폴트값으로 
>
>  하여 반환합니다.
>
>   (lambda 호출과 연산은 key가 없는 경우에만 진행되므로 불필요한 연산을 줄일 수 있습니다.)
>
>- Lambda 속에 Lambda가 중첩되어 사용되거나, 여러 Collection operation 확장함수를 연달아 사용하여 
>
>  Lambda가 여러번 사용될 때, it은 의미를 혼동하게할 가능성이 있으므로 인자를 명시적으로 네미밍하는
>
>   것을 장려합니다.
>
>- Collection operation은 매우 다양하며 동일한 연산을 위해 가장 간단하고 명확한 operation을 선택해야 
>
>  합니다. 아래 2개 코드는 사실상 동일한 연산이지만 후자가 보다 명료합니다.
>
>  ```kotlin
>   val (first, second) = heroes
>          .flatMap { heroes.map { hero -> it to hero } }
>          .maxBy { it.first.age - it.second.age }!!
>  -> argument를 넣어 it을 확실하게 할 것
>   val allPossiblePairs = heroes
>       .flatMap { firstHero ->
>            heroes.map{
>                  secondHero -> firstHero to secondHero
>            }
>       }
>  val (oldest,youngest) = allPossiblePairs.maxBy{it.first.age-it.second.age}!!
>  //혹은 
>  val oldestHero = heroes.maxBy { it.age }
>  val youngestHero = heroes.minBy { it.age }
>  println(oldestHero?.name)
>          
>  ```

#### Function Types

>- Lambda, 명시적인 익명함수 정의, 그리고 다음 강의(5. Member Reference)에서 배울 함수의 reference를 통해 함수를 Variable에 저장할 수 있으며 이 때 Function Type이 정의된다.
>
>  변수 타입 추론과 마찬가지로 타입 추론도 가능합니다.
>
>```kotlin
>val isEven : (Int) -> Boolean = { i : Int -> i % 2 == 0 } 
>val isEven = { i : Int -> i % 2 == 0 } //타입 추론
>```

#### Member References

>앞서 Collection operation에 대해 lambda를 사용한 이유는 operation이 함수
>
> (ex: predicate, 연산을 거친 argument)를 인자로 사용하기 때문이다. 
>
>한편, Kotlin에서 선언적인 function을 variable에 저장하고 인자로 사용할 수 없지만 lambda 외에 function
>
> reference는 variable에 저장하고 인자로 사용할 수 있습니다.
>
>```kotlin
>fun isEven(i:Int):Boolean = i % 2 == 0
>val predicate = isEven // fun을 통해 선언한 함수는 변수에 저장 못하며 오류발생
>val predicate2 = ::isEven // function reference는 변수에 저장 가능 
>val predicate3 = {i:Int -> isEven(i)} // lambda 형태로 변수에 저장 가능
>```
>
>이미 선언된 함수를 인자로 사용하고자 하는 경우 lambda보다 function reference 방식이 보다 코드가 간소화 된다.
>
>```kotlin
>//Android 코드 예시 (정의된 클릭 리스너 함수를 버튼 어댑터에 인자로 넣어야 하는 경우)
>// 1. lambda 방식
>val buttonAdapter = ButtonAdapter(buttons, {button: Button -> buttonClicked(button) })
>// 2. function reference 방식
>val buttonAdapter = ButtonAdapter(buttons, ::buttonClicked)
>```
>
>- Class에 memeber function이 있고 이에 대한 member function reference를 변수에 저장하고자 할 때, 
>
>  Class로 생성한 특정 객체에 대한 member reference를 저장하면 bound reference라 하고, 특정 객체가 
>
>  아닌 Class에 대한 memeber reference 혹은 top-level function의 reference는 non-bound reference
>
>  라고 합니다.
>
>```kotlin
>class Person(val name:String, val age:Int){
>      fun isOlder(ageLimit: Int) = age > ageLimit 
>val jeff = Person("Jeff", 35)
>    
>// 1. bound reference
>val agePredicate = jeff::isOlder
>println(agePredicate(21))
>    
>// 2. non-bound reference (변수에 저장된 함수 호출시 객체를 인자로 넣어야 함) 
>val agePredicate2 = Person::isOlder 
>println(agePredicate2(jeff, 21))
>```

#### Return from Lambda

>Kotlin에서 return은 기본적으로 fun 키워드로 명시된 곳에 대응된다. 
>
>한편, lambda는 fun 키워드로 선언되지 않으므로 lambda내부에 return을 사용할 때 주의해야 한다. 
>
>labeling 또는 return을 사용하지 않는 방법이 있고, local function을 정의하거나, 명시적인 익명함수를 사용하는 방법이 있다.
>
>```kotlin
>/**
>* 1. 아래 코드에서 원소가 0인 경우 해당 원소에 대한 transform 결과물이 []가 되는 
>* 것이 아니라 duplicateNonZero의 반환값이 []가 되어 버림
>*/
>fun duplicateNonZero(list:List<Int>):List<Int>{
>    return list.flatMap {
>        if(it==0) return listOf() 
>        listOf(it, it)
>    }
>}
>// 2. lambda에 l@, @l 라벨링을 통해 return 이 대응되어야 할 지점 설정 
>fun duplicateNonZeroLabel(list:List<Int>):List<Int>{
>    return list.flatMap l@{
>        if(it==0) return@l listOf() 
>        listOf(it, it)
>    }
>} // 혹은 @flatMap으로 사용해도 가능
>// 3. lambda에 return을 사용하지 않음 
>fun duplicateNonZeroNoReturn(list:List<Int>):List<Int>{
>    return list.flatMap {
>        if(it==0) listOf()
>        else listOf(it, it)
>   }
>}
>// 4. local function (fun 키워드 선언)과 function reference를 사용 
>fun duplicateNonZeroLocalFunction(list:List<Int>):List<Int>{
>    fun duplicateNonZeroElement(e: Int): List<Int>{
>        if(e==0) return listOf()
>        return listOf(e, e)
>    }
>    return list.flatMap(::duplicateNonZeroElement)
>}
>// 5. anonymous function을 정의 (fun 키워드 선언)
>fun duplicateNonZeroAnonymousFunction(list:List<Int>):List<Int>{
>    return list.flatMap(fun (e): List<Int>{
>        if(e==0) return listOf()
>        return listOf(e,e)
>    })
>}
>```
>
>- lambda와 명시적인 익명함수는 bytecode level에서는 동일하나 return에 대한 대응 지점만 달라진다.
>
>   (Kotlin이 return을 fun 키워드 기준으로 대응시키는 규칙 때문)

#### Properties

>Kotlin은 properties를 기능으로써 지원하여 문법적으로 간결하게 사용할 수 있다.
>
>Kotlin에서 클래스를 정의할 때 클래스 내부에 변수를 val로 정의하면 Read-only property (getter)가, var
>
>로 정의하면 Mutable property (getter/setter)가 자동으로 생성된다.
>
>Kotlin에서는 field 정의시 자동으로 accessor가 구현되어 클래스 외부에서는 field에 직접적으로 접근할 수 
>
>없도록 한다. `<객체명>.<필드명>` 형태로 접근하더라도 Kotlin 컴파일러가 자동으로 getter/setter로 변환
>
>한다. 하지만 클래스 내부의 accessor에서 `field` 키워드를 사용한 경우에는 field에 직접적인 접근이 가
>
>능하다. (아래 코드 참고) 또한, 클래스 내부 메소드에서 `<객체명>.<필드명>` 형태로 접근한 경우 accesso
>
>r를 커스터마이징한 경우 accessor로 (ex: `this.setState()`), 커스터마이징 하지 않은 경우 field로 (ex: 
>
>`this.state`) Kotlin 컴파일러가 선택적으로 변환합니다.
>
>```kotlin
>class StateLogger {
>    var state = false
>        set(value) {
>            // accessor 내부에서 field 키워드로 접근시 Java코드상에서 
>            // this.state가 호출된다. 
>            println("state has changed: $field -> $value")
>            field = value
>        }
>    
>    fun printState(){
>        // 클래스 내부 메소드에서 field에 접근시 
>        // getter는 커스터마이징하지 않았으므로, this.state가 호출된다.               
>       println("$state")
>    }
>fun setOppositeState(bool: Boolean){
>         // setter는 커스터마이징 했으므로, this.setState()가 호출된다. 
>        state = !bool
>    }
>}
>```
>
>val은 엄밀히 따지면 read-only (reassign이 안됨) 를 뜻하는 것이며, immutable한 것은 아니다. 
>
>val로 선언한 properties는 mutable(unstable) 할 수 있다.
>
>getter 호출시마다 값이 달라지는 사례 : Random 함수를 쓰는 경우, 
>
>getter 내부에 field의 값을 변경시키는 로직을 넣는 경우

## More about properties

>Interface에도 Property를 정의할 수 있는데, 이는 컴파일시에 구현되지 않은 accessor 메소드
>
>(val의 경우 getter only, var의 경우 getter&setter)들로 변환된다.
>
>interface smart casts 기능이 동작하지 않는 3가지 상황이 존재한다. 
>
>1) interface 타입인 properties의 getter를 커스터마이징한 경우, 위 *Unstable val 실습 코드 작성시 고려할 점* 에서 살펴본 것처럼 getter 호출시마다 값이 mutable할 수 있는데 이 경우 타입 체크를 했더라도 다시 호출할 경우 다른 구현 class 타입이 반환될 가능성이 있으므로 동일 타입을 보장할 수 없습니다. 
>
>2) interface 에서 interface 타입 properties를 정의한 경우 해당 properties의 accessor 메소드는 open이며 재정의 과정에서 getter가 커스터마이징되어 1)과 동일한 이슈가 발생할 수 있습니다. 
>
>3) interface 타입 properties를 mutable로 선언한 경우 setter를 통해 값이 변경될 가능성이 있습니다. (아래 코드 참고) 이 경우에 대한 방안은 local variable에 getter 메소드 반환 값을 저장하여 사용하는 것입니다.

