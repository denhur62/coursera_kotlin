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

