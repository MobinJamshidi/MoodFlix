package com.example.moodflix.utils

object MoodAnalyzer {

    private val KeywordGenere = mapOf(
        // کمدی (35)
        "شاد" to 35, "خنده" to 35, "کمدی" to 35, "طنز" to 35, "بامزه" to 35, "funny" to 35, "comedy" to 35,

        // جنگی (10752) و اکشن (28)
        "جنگ" to 10752, "ارتش" to 10752, "سرباز" to 10752, "war" to 10752,
        "اکشن" to 28, "تفنگ" to 28, "مبارزه" to 28, "action" to 28,

        // عاشقانه و مسائل بزرگسالان
        "عشق" to 10749, "عاشقانه" to 10749, "رمانتیک" to 10749, "بوسه" to 10749,
        "سکسی" to 10749, "شهوت" to 10749, "هوس" to 10749, "رابطه" to 10749, "hot" to 10749, "sexy" to 10749, "love" to 10749,

        // ترسناک (27)
        "ترس" to 27, "وحشت" to 27, "جن" to 27, "روح" to 27, "horror" to 27, "scary" to 27,

        // غمگین (18)
        "غم" to 18, "گریه" to 18, "ناراحت" to 18, "درام" to 18, "sad" to 18, "drama" to 18
    )

    fun extractGenerId(userText : String): String {
        val foundGenres = mutableSetOf<Int>()

        val words = userText.lowercase().split(" ", "،", ".", ",", "!", "?")

        words.forEach { word ->
            KeywordGenere.forEach { (keyword , id) ->
                if (word.contains(keyword)){
                    foundGenres.add(id)
                }
            }
        }
        return foundGenres.joinToString(",")
    }


}