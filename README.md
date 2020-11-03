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

### Properties

>Kotlin은 properties를 기능으로써 지원하여 문법적으로 간결하게 사용할 수 있다.
>
>Kotlin에서 클래스를 정의할 때 클래스 내부에 변수를 val로 정의하면 Read-only property (getter)가, var
>
>로 정의하면 Mutable property (getter/setter)가 자동으로 생성된다.
>
>자바에서는 데이터를 **필드(field)**에 저장한다. `name`과 `isMarried`라는 데이터를 Person클래스의 필드에 저장한 것이다. 한편 각 데이터마다 적용되는 getter와 setter를 **접근자**라 부른다. 이 접근자를 통해서 가시성이 private인 데이터들에 접근할 수 있다.
>
>Kotlin 에서는 필드와 접근자를 통틀어서 **프로퍼티** 라고 부른다. 
>
>##### 주의할 점
>
>>디컴파일한 자바 코드에서 필드가 private이라고 하여 코틀린의 프로퍼티도 private은 아니다. 이게 무슨말인가 싶겠지만, **필드와 프로퍼티를 다르게 인식할 줄 알아야 한다.** 
>>
>>자바는 기본적으로 필드로 다루고, 코틀린은 프로퍼티(필드 + 접근자)를 기본으로 다루는 언어다.
>>
>>만일 프로퍼티가 private 이기 위해서는 
>>
>>```kotlin
>>class Person(private var name: String)
>>```
>>
>>를 디컴파일 자바코드로 보게 되면 
>>
>>```kotlin
>>public final class Property {
>>   private String name;
>>
>>   public Property(@NotNull String name) {
>>      Intrinsics.checkParameterIsNotNull(name, "name");
>>      super();
>>      this.name = name;
>>   }
>>}
>>```
>>
>>getter와 setter가 없어서 프로퍼티가 private이라고 볼 수 있다.
>
>#### Backing Fields
>
>>getter 와 setter를 생략하지 않고 선언하는 방법은 커스텀 접근자를 작성 할 때 backing Field를 사용 할 수 있다.
>>
>>```kotlin
>>class person(){
>>    var id=0
>>    get()=100
>>    var name= "suzuki"
>>    set(value){name=value}
>>}
>>```
>>
>>코드가 무난 한 것 같지만 디 컴파일을 해보면 this.setName(value)로 나오는 것을 보고 무한루프를 도는 것을 알 수 있다. 따라서 위의 코드를
>>
>>```kotlin
>>class person(){
>>    var id=0
>>    get()=100
>>    var name= "suzuki"
>>    set(value){field=value}
>>}
>>```
>>
>>backing Field를 사용하여 set함수를 적용한다. 
>
>Kotlin에서는 field 정의시 자동으로 accessor가 구현되어 클래스 외부에서는 field에 직접적으로 접근할 수 
>
>없도록 한다. `<객체명>.<필드명>` 형태로 접근하더라도 Kotlin 컴파일러가 **자동으로 getter/setter로 변환**
>
>**한다**. 하지만 클래스 내부의 accessor에서 `field` 키워드를 사용한 경우에는 field에 직접적인 접근이 가
>
>능하다. (아래 코드 참고) 또한, 클래스 내부 메소드에서 `<객체명>.<필드명>` 형태로 접근한 경우 accesso
>
>r를 커스터마이징한 경우 accessor로 (ex: `this.setState()`), 커스터마이징 하지 않은 경우 field로 (ex: 
>
>`this.state`) Kotlin 컴파일러가 선택적으로 변환합니다.
>
>```kotlin
>class StateLogger {
>var state = false
>   set(value) {
>       // accessor 내부에서 field 키워드로 접근시 Java코드상에서 
>       // this.state가 호출된다. 
>       println("state has changed: $field -> $value")
>       field = value
>   }
>
>fun printState(){
>   // 클래스 내부 메소드에서 field에 접근시 
>   // getter는 커스터마이징하지 않았으므로, this.state가 호출된다.               
>  println("$state")
>}
>fun setOppositeState(bool: Boolean){
>    // setter는 커스터마이징 했으므로, this.setState()가 호출된다. 
>   state = !bool
>}
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
>1) interface 타입인 properties의 getter를 커스터마이징한 경우, 위 *Unstable val 실습 코드 작성시 고려할 점* 에서 살펴본 것처럼 getter 호출시마다 값이 mutable할 수 있는데 이 경우 타입 체크를 했더라도 다시 호출할 경우 다른 구현 class 타입이 반환될 가능성이 있으므로 동일 타입을 보장할 수 없다. 
>
>2) interface 에서 interface 타입 properties를 정의한 경우 해당 properties의 accessor 메소드는 open이며 재정의 과정에서 getter가 커스터마이징되어 1)과 동일한 이슈가 발생할 수 있다. 
>
>3) interface 타입 properties를 mutable로 선언한 경우 setter를 통해 값이 변경될 가능성이 있다. (아래 코드 참고) 이 경우에 대한 방안은 local variable에 getter 메소드 반환 값을 저장하여 사용하는 것이다.
>
>```kotlin
>// 아래에 정의한 User interface를 properties로 사용하는 경우 
>interface User {
>val nickname: String
>}
>// 1. Interface 타입의 property의 getter를 커스텀한 경우 
>class SessionI{
>val user: User
>   get(){
>       return TODO()
>   }
>}
>// 2. Interface에서 Interface 타입 property를 정의한 경우 
>interface SessionII{
>val user: User 
>}
>// 3. Interface 타입의 property를 mutable(var)로 선언한 경우 
>class SessionIII(var user:User)
>
>fun analyzeUserSession(session: Session, sessionII: SessionII, sessionIII: SessionIII){
>/*
>아래 println 두줄 모두 is a property that has open or custom getter      메시지와 함께 오류가 뜸
>*/
>if(session.user is FacebookUser){
>   println(session.user.accountId)  
>}
>if(sessionII.user is FacebookUser){
>   println(sessionII.user.accountId)
>}
>
>//아래 println 의 경우 is a mutable property that could have been changed by this 		time 메시지와 함께 오류가 뜸
>
>if(sessionIII.user is Facebookuser){
>   println(sessionIII.user.accountId)
>}
>// 아래처럼 local variable에 getter의 값을 저장하는 경우 smart casts 동작
>val userI = session.user
>if (userI is FacebookUser) { println(userI.accountId) }
>val userII = sessionII.user
>if (userII is FacebookUser) { println(userII.accountId) }
>val userIII = sessionIII.user
>if (userIII is FacebookUser) { println(userIII.accountId) }
>}
>```
>
>```kotlin
>interface User {
>    val nickname: String
>}
>// 1번. 주 생성자 안에 프로퍼티를 직접 선언함
>class PrivateUser(override val nickname: String) : User
>
>// 2번. 커스텀 게터로 프로퍼티를 설정함.
>class SubscribingUser(val email: String) : User {
>    override val nickname: String
>        get() = email.substringBefore('@')
>}
>
>// 3번. 초기화 식으로 프로퍼티 값을 설정함.
>class FacebookUser(val accountId: Int) : User {
>    override val nickname = getFacebookName(accountId)
>}
>```
>
>여기서 2번 SubsribingUser와 3번 FacebookUser를 구현하는 방법의 차이에 주의해야 한다. 
>
>SubscribingUser의 nickname 프로퍼티는 매번 호출될때마다 substringBefore를 호출하여 계산하는 커스텀 게터를 활용한다.
>
>이와 다르게 FacebookUser의 nickname 프로퍼티는 객체를 초기화할 때 계산한 데이터를 뒷받침하는 필드(backing fields)에 저장했다가 불러오는 방식을 활용한다.

#### **Extension properties** 

>확장 함수는 해당 클래스에 대해 빈번히 사용되는 연산 작업이며, 확장 프로퍼티는 해당 클래스에 대해 빈번히 사용되는 정보와 속성을 저장한다.
>
>```kotlin
>// 특정 String 타입 객체의 마지막 index값을 반환하는 lastIndex 확장프로퍼티 
>val String.lastIndex : Int
>    get() = this.length - 1
>// 특정 StringBuilder 타입 객체의 마지막 글자를 반환하고, 마지막 글자를 재할당할 수 // 있는 lastChar 확장 프로퍼티
>var StringBuilder.lastChar: Char
>    get() = get(this.length - 1)
>    set(value: Char){
>        this.setCharAt(length-1, value)
>    }
>```

#### Lazy or late initialization

>Kotlin에서는 `by lazy` 키워드를 통해 Lazy Properties를 정의할 수 있다.
>
>1) lambda를 run 통해 실행시키는 경우 변수 호출 여부와 무관하게 무조건 연산을 수행하여 반환 값을
>
>​	 저장한다. ( 부르지 않아도 실행)
>
>2) property의 경우 호출되기 전까지는 실행되지 않지만, 호출 시마다 매번 연산이 수행된다. 
>
>3) lazy property의 경우 호출되기 전까지는 실행되지 않으며, 최초 1회 호출시에만 연산이 수행되고 반환 값을 저장한다.
>
>```kotlin
>// 1. lambda를 run을 통해 실행시키는 경우
>val ValueI : String = run {
>println("computed! - run lambda")
>"Hello"
>}
>// 2. property를 사용하는 경우 
>val ValueII : String
>get() {
>   println("computed! - property")
>   return "Hello"
>}
>// 3. lazy property를 사용하는 경우
>val ValueIII : String by lazy {
>println("computed! - lazy property")
>"Hello"
>}
>```

**Late initialization**

>- 특정한 목적에 따라 Property를 클래스 생성자 (Constructor)가 아니라 특정한 다른 지점에서 초기화해야 하는 상황에 유용한 기능이다. 사용되는 예시로 안드로이드 액티비티, JUnit 테스트, 의존성 주입 등이 있다. (관련 링크 : [Medium 블로그](https://medium.com/til-kotlin-ko/kotlin-delegated-property-by-lazy는-어떻게-동작하는가-74912d3e9c56) 중 lateinit 부분)
>- 이러한 상황에 대한 Java 대응 방식은 생성자에서 우선 null로 초기화했다가 추후 특정 지점에서 다시 재할당하는 방식이다. 하지만 이 경우 해당 변수를 Nullable type으로 선언해야 하며 이로인해 이 변수를 다루는 과정에서 계속 Nullability 관련 연산자를 사용해야 하는 비효율성이 발생한다. 이 경우 변수 앞에 `lateinit` 키워드를 써주면 Non-nullable 타입으로 처리할 수 있다.
>- Late initialization은 사실 변수 선언시 null로 초기화했다가, 개발자가 실제로 유의미한 초기화를 하는 특정 지점에서 다시 재할당을 하는 방식으로 컴파일 된다. 이에 따라 `lateinit` 키워드는 `val` 키워드에는 사용할 수 없도록 언어적으로 제한되어 있다.
>- Late initialization은 불필요한 Nullability 관련 코드를 제거해주는 목적의 문법이므로 `lateinit` 키워드로 선언된 변수는 Nullable type이 될 수 없도록 제한되어 있다. 또한 Primitive type (Int, Boolean, Char 등)의 경우 개발자가 구현하는 의도에 맞춘 디폴트 값을 주는 것이 가능하므로 (ex: 0, false, ‘’ 등) `lateinit` 키워드를 사용할 수없도록 제한되어 있습니다.
>- `lateinit` 키워드로 선언된 변수의 초기화 여부를 `.isInitialized`를 통해 체크할 수 있다. 이는 컴파일 과정에서 null 여부를 확인하는 if 조건문으로 구현됩니다.
>- 위와 같이 late initialization은 사실상 Java 방식과 동일하게 동작한다. 다만, 실용적 관점에서 클래스 생성자가 아닌 특정 지점에서만 변수 초기화가 가능하고, 실제로 해당 변수는 그 지점 이후에만 역참조되는 경우들이 있는데 (ex: 안드로이드 액티비티 onCreate) 이 때 단순 반복적인 코드를 Kotlin 컴파일러 레벨에서 자동으로 생성해주어 Kotlin 코드 간결성을 개선해 준다는 의미가 있다.

#### lateinit 유의사항

>late initialization은 앞서 배운 Non-null assertion (`!!` )과 유사하게 개발자가 해당 변수가 반드시 초기화 이후에 역참조될 것이라는 확신이 있을 때만 사용해야 하는 것으로, (ex: 안드로이드 액티비 onCreate) 초기화 전에 역참조가 발생할 경우 UninitializedPropertyAccessException 이라는 런타임 에러가 발생한다.
>
> 다만, NullPointerException과 달리 에러 문구에서 정확히 어떤 변수에서 문제가 발생했는지 명시적으로 알려주므로 오류 수정시 상대적으로 용이하다는 장점이 있다.
>

#### OOP in Kotlin

>Kotlin은 public, protected, internal, private의 4가지 수준이 존재하며, 디폴트는 public이다.
>
>```kotlin
>class Person
>internal constructor(name: String, age:Int){ //생성자에 대한 가시성을 변경하는 문법
>    val name:String
>    var age:Int
>    init {
>        this.name = name
>        this.age = age
>    }
>    
>    constructor(name: String, birthYear:Int, nowYear:Int) : this (name, nowYear-birthYear+1)
>}
>// 아래와 같이 상황에 따라 다른 매개변수 유형과 개수로 객체 생성 가능 
>val person1 = Person("kevin", 28)
>val person2 = Person("kevin", birthYear = 1992, nowYear = 2001)
>```
>
>생성자 오버로딩 (생성자 매개변수의 유형과 개수를 다르게 하는 여러 생성자를 구현하는 것) 이 필요한 경우 클래스 내부에 `constructor` 를 통해 Secondary Constructor를 정의할 수 있다. 
>
>단, secondary constructor 는 반드시 Primary constructor 또는 다른 secondary constructor를 호출해야 한다.
>
>Java에서 상속관계인 클래스들의 생성자 호출 순서는 자식클래스 생성자 호출시 우선 부모클래스 생성자가 호출되며 부모클래스 생성자 내부 로직 실행 -> 자식 클래스 생성자 내부 로직 실행의 순서로 실행된다.

#### Class modifiers — I, II

>**Enum class**
>
>>- Enum은 Enumeration (목록)을 의미하며, Java와 동일하게 고정된 갯수의 값들로 구성된 목록이 필요할 때 사용한다.
>>
>>```kotlin
>>import Color.*// 색상 목록의 각 색상 항목마다 서로 다른 r, g, b 속성 정보를 가짐 -> 프로퍼티로 구현
>>enum class Color(val r:Int, val g:Int, val b:Int){
>>    BLUE(0,0,255),
>>    ORANGE(255,165,0),
>>    RED(255,0,0); // 세미콜론을 통해 Enum list와 member list를 구분// 색상 목록의 각 색상 항목마다 rgb값을 구하는 연산이 필요 -> 메소드로 구현
>>    fun rgb() = (r * 256 + g) * 256 + b
>>}fun main(args: Array<String>){
>>    println(BLUE.r)
>>    println(BLUE.rgb())
>>}
>>```
>>
>>메소드는 목록의 각 항목에 대해 빈번하게 수행되는 연산이 있는 경우 유용하다.
>
>**data class**
>
>>Kotlin에서 `==`연산자는 컴파일 과정에서 `equals()` 메소드로 변환되며, `===` 연산자가 reference equality를 체크한다. 
>>
>>한편 개발자가 직접 구현하는 클래스의 경우 의도에 적합하도록 `equals()` 를 재정의해주어야 하는데 data class로 선언하는 경우 자동적으로 구성 요소가 모두 동일한지 비교하는 메소드를 생성해 준다.
>
>**Sealed class**
>
>>Sealed class는 고정된 상속 계층 구조를 가지는 클래스를 다룰 때 사용한다. 
>>
>>선언된 상속클래스 외에 다른 클래스가 없음을 보장하므로, Enum class 처럼 `when` expression 을 사용할 때 불필요한 `else` 분기를 만들지 않아도 되어 코드를 간결하게 만들 수 있다.
>
>**Inner/ nested class**
>
>>일반적인 유스케이스에서 내부에 선언된 클래스가 외부 클래스에 대한 역참조를 필요로 하지 않는 경우가 많고, 이 경우 불필요한 메모리 누수를 줄이기 위해 정적 중첩 클래스가 낫기 때문이다.
>>
>>물론 상황에 따라 해당하는 클래스를 사용하면 된다.

#### **Class delegation**

>인터페이스에 구현되지 않은 메소드들이 있고, 
>
>클래스에서 이 인터페이스를 프로퍼티로 사용할 경우 클래스 구현 과정에서 메소드를 구현할 필요 없이 추후 클래스 객체 생성시에 인자로 받을 인터페이스 구현체에게 메소드 구현을 위임할 수 있다. 
>
>```kotlin
>interface Repository{
>    fun getById(id: Int): Customer
>    fun getAll() : List<Customer>
>}interface Logger{
>    fun logAll()
>}class Controller(
>    val repository: Repository, 
>    val logger: Logger
>) : Repository, Logger {
>    override fun getById(id: Int): Customer = repository.getById(id)
>    override fun getAll(): List<Customer> = repository.getAll()
>    override fun logAll() = logger.logAll()
>}
>```
>
>위 코드 처럼 모든 위임 메소드 (delegating methods)를 직접 코딩하는 것은 번거로운 단순 작업이다. 이 경우에 대해 Kotlin은 Class delegation 을 지원하며 `by` 키워드를 사용하면 컴파일 과정에서 위임 메소드를 자동으로 생성해주어 코드를 간결하게 만들 수 있다.
>
>```kotlin
>class Controller(
>    val repository: Repository, 
>    val logger: Logger
>) : Repository by repository, Logger by logger
>```
>
>위임 클래스를 통해 코드를 간결하게 만들수 있다. 

#### Objects, object expressions & companion objects

>`**object**` **키워드와 object declaration**
>
>>```kotlin
>>// Java 코드에서 싱글톤 패턴 구현
>>public class JSingleton {
>>    public static final JSingleton INSTANCE = new JSingleton();
>>    private JSingleton() { }
>>    public void foo() { System.out.println("foo"); } 
>>}
>>// Java 싱글톤패턴 객체 멤버 호출 방법
>>JSingleton.INSTANCE.foo();// 위와 동일하게 동작하는 Kotlin 코드 
>>object KSingleton {
>>    fun foo() { println("foo") }
>>}
>>// Kotlin 싱글톤 패턴 객체 멤버 호출 방법
>>KSingleton.foo()
>>```
>>
>>Java에서는 싱글톤 패턴을 사용하기 위해 관용적인 단순 코드 작성 작업이 필요하다.
>>
>>한편, Kotlin은 `object` 키워드를 쓰면 컴파일 과정에서 싱글톤 패턴을 위한 코드를 자동으로 생성해주고, 관용적인 `INSTANCE` 필드 호출을 생략해주어 코드 간결성을 높일 수 있다.
>
>**object expression**
>
>>Kotlin에서 구현할 인터페이스가 오직 1개의 추상 메소드 (abstract method)만 가질 경우 lambda로 구현할 수 있다. 
>>
>>인터페이스가 여러개의 추상 메소드를 가질 경우 object expression으로 구현할 수 있다.
>>
>>object expression도 `object :` 키워드를 사용하지만 이 때 생성되는 객체는 호출시마다 매번 새롭게 생성되며 앞선 싱글톤 패턴 (object declaration)과 무관하다.
>>
>>익명(이름없는) 오브젝트 (anonymous object) 는 local 과 private 선언에서만 type 으로써 사용될 수 있다.
>>
>>익명 오브젝트 (anonymous object) 를 public 함수의 리턴 타입으로 쓰거나 public property 의 타입으로 쓰면 둘의 실제 타입은 anonymous object 의 선언된 supertype 되거나, supertype 을 선언 안한 경우엔 **Any** 이 되게 된다.
>>
>>anonymous object 에 추가된 멤버들은 접근이 불가능 해 진다.
>>
>>```kotlin
>>class C { 
>>    // Private function, so the return type is the anonymous object type private
>>    fun foo() = object { val x: String = "x" } 
>>    // Public function, so the return type is Any
>>    fun publicFoo() = object { val x: String = "x" } 
>>    fun bar() { val x1 = foo().x // Works 
>>               val x2 = publicFoo().x // ERROR: Unresolved reference 'x' } }
>>
>>
>>```

**No static keyword**

>**@JvmStatic**
>
>> companion object를 통한 외부클래스 내부의 싱글톤 패턴 클래스는 사실
>>
>> `<외부 클래스명>.Companion.<멤버>` 를 Kotlin 컴파일러가 `<외부 클래스명>.<멤버>`로 간소화하여 
>>
>> 사용할 수 있도록 하는 것이다. 
>>
>> 따라서 해당 Kotlin 코드를 Java에서 사용할 경우 Kotlin 코드와 달리 `.INSTANCE` , `.Companion` 작성이 필요하다.
>>
>> 이는 Java 상호운용성 측면에서 혼동의 여지가 있으며, object/companion object 내부의 멤버에 대해 `@JvmStatic` 어노테이션을 붙이면 Java에서도 Kotlin과 동일한 코드로 사용할 수 있다.
>>
>> 즉  `@JvmStatic`는 Companion에 등록된 변수를 자바의 static처럼 선언하기 위한 annotation이다.
>
>**Inner object (Inner modifier with object)**
>
>>외부클래스 내부 object에 대해서는 `inner` 제어자를 사용할 수 없다. 
>>
>>왜냐하면 `inner` 제어자는 non-static nested class를 의미하는데, object는 싱글톤 패턴 클래스로 static 이어서 상충되기 때문이다.
>
>#### Constants
>
>>상수 (constants)로서 클래스 멤버 변수란 해당클래스에 대해 고정된 값을 가지는 속성을 의미한다.
>>
>> (ex: 원주율) 상수는 각 객체에 종속되지 않고 동일한 값을 가져야 하며, 한번만 초기화 되어야 하므로 Java에서는 static과 fianl을 통해 구현한다. 
>>
>>Kotlin 에서는 `const` 제어자 또는 `@JvmField` 어노테이션을 통해 상수를 구현한다. 
>>
>>`const` 제어자를 사용하면 컴파일 과정에서 상수 변수를 해당 값으로 치환하며 (단, Primitive type 또는 String에 대해서만 동작), 
>>
>>`@JvmField` 어노테이션을 사용하면 프로퍼티를 accessor를 통해서가 아니라 직접 필드에 접근할 수 있도록 하는 방식으로 mutability를 차단하여 상수를 구현한다.
>
>![image-20201103194200053](README.assets/image-20201103194200053.png)
>
>![image-20201103194213322](README.assets/image-20201103194213322.png)
>
>

