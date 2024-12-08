//Колекция list
//fun main() {
//    val list1 = listOf(1, 2, 2, 3, 4, 4, 4, 5, 6, 6)
//    val list2 = listOf(1, 1, 1, 1)
//    val list3 = listOf<Int>()
//    val list4 = listOf(1, 3, 5, 7, 9)
//    val list5 = listOf(1,2,2,3,3,3,4,5,5,6,7,7,7,8,9,9,10)
//
//
//    println("Список 1: Количество различных элементов = ${countDistinctElements(list1)}")
//    println("Список 2: Количество различных элементов = ${countDistinctElements(list2)}")
//    println("Список 3: Количество различных элементов = ${countDistinctElements(list3)}")
//    println("Список 4: Количество различных элементов = ${countDistinctElements(list4)}")
//    println("Список 5: Количество различных элементов = ${countDistinctElements(list5)}")
//
//}
//fun countDistinctElements(list: List<Int>): Int {
//    if (list.isEmpty()) return 0
//
//    var count = 1
//    var previousElement = list[0]
//
//    for (i in 1 until list.size) {
//        if (list[i] > previousElement) {
//            count++
//            previousElement = list[i]
//        }
//    }
//
//    return count
//}

//Коллекция set

//fun main() {
//    val numStudents = readLine()!!.toInt()
//    val studentLanguages = mutableListOf<Set<String>>()
//
//    for (i in 0 until numStudents) {
//        val numLanguages = readLine()!!.toInt()
//        val languages = mutableSetOf<String>()
//        for (j in 0 until numLanguages) {
//            languages.add(readLine()!!)
//        }
//        studentLanguages.add(languages)
//    }
//
//    // Языки, которые знают все школьники
//    val allLanguages = studentLanguages.reduce { acc, set -> acc.intersect(set) }
//    println(allLanguages.size)
//    allLanguages.sorted().forEach { println(it) }
//
//
//    // Языки, которые знает хотя бы один школьник
//    val anyLanguages = studentLanguages.reduce { acc, set -> acc.union(set) }
//    println(anyLanguages.size)
//    anyLanguages.sorted().forEach { println(it) }
//}

//map
fun main() {
    val n = readLine()!!.toInt()
    val englishToLatin = mutableMapOf<String, MutableSet<String>>()

    for (i in 0 until n) {
        val line = readLine()!!.split("-")
        val englishWord = line[0].trim()
        val latinWords = line[1].trim().split(", ").toMutableSet()
        englishToLatin[englishWord] = latinWords
    }

    val latinToEnglish = mutableMapOf<String, MutableSet<String>>()
    for ((englishWord, latinWords) in englishToLatin) {
        for (latinWord in latinWords) {
            latinToEnglish.getOrPut(latinWord) { mutableSetOf() }.add(englishWord)
        }
    }

    val sortedLatinWords = latinToEnglish.keys.sorted()

    for (latinWord in sortedLatinWords) {
        val englishTranslations = latinToEnglish[latinWord]!!.sorted()
        println("${englishTranslations.joinToString(" ")} - ${latinWord}")
    }
}

