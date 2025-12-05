package com.example.moodflix.utils

object MoodAnalyzer {

    private val keywordToGenre = mapOf(
        "عشق" to 10749, "عاشقانه" to 10749, "رمانتیک" to 10749, "بوسه" to 10749, "رابطه" to 10749,
        "سکسی" to 10749, "سکس" to 10749, "شهوت" to 10749, "جنسی" to 10749, "داغ" to 10749,
        "صحنه دار" to 10749, "لختی" to 10749, "برهنه" to 10749, "هوس" to 10749, "بزرگسال" to 10749,
        "مثبت 18" to 10749, "نامزدی" to 10749, "ازدواج" to 10749, "همسر" to 10749, "خواب" to 10749,
        "بغل" to 10749, "آغوش" to 10749, "احساسی" to 10749, "دلبر" to 10749,
        "love" to 10749, "romance" to 10749, "sex" to 10749, "sexy" to 10749, "hot" to 10749,
        "erotic" to 10749, "kiss" to 10749, "lust" to 10749, "passion" to 10749, "adult" to 10749,
        "nude" to 10749, "naked" to 10749, "couple" to 10749, "intimate" to 10749, "18+" to 10749,


        "شاد" to 35, "خنده" to 35, "کمدی" to 35, "طنز" to 35, "بامزه" to 35, "مسخره" to 35,
        "قهقهه" to 35, "فان" to 35, "جک" to 35, "حال خوب" to 35, "خوشحال" to 35, "شادی" to 35,
        "لول" to 35, "باحال" to 35, "سرگرمی" to 35, "دیوونه بازی" to 35,
        "funny" to 35, "comedy" to 35, "laugh" to 35, "happy" to 35, "fun" to 35,
        "hilarious" to 35, "joke" to 35, "smile" to 35, "crazy" to 35,

        "اکشن" to 28, "بزن بزن" to 28, "تفنگ" to 28, "مبارزه" to 28, "دعوا" to 28, "خشن" to 28,
        "هیجان" to 28, "انرژی" to 28, "تند" to 28, "تعقیب" to 28, "شلیک" to 28, "کتک" to 28,
        "پلیس بازی" to 28, "انفجار" to 28, "بمب" to 28, "تیراندازی" to 28,
        "action" to 28, "fight" to 28, "gun" to 28, "shoot" to 28, "fast" to 28,
        "violence" to 28, "explosion" to 28, "kill" to 28,

        "جنگ" to 10752, "ارتش" to 10752, "سرباز" to 10752, "دفاع" to 10752, "تانک" to 10752,
        "خونین" to 10752, "عملیات" to 10752, "شهید" to 10752, "جبهه" to 10752, "کمین" to 10752,
        // انگلیسی
        "war" to 10752, "army" to 10752, "soldier" to 10752, "battle" to 10752, "military" to 10752,


        "ترس" to 27, "وحشت" to 27, "جن" to 27, "روح" to 27, "خون" to 27, "مرگ" to 27, "دلهره" to 27,
        "زامبی" to 27, "تاریک" to 27, "جیغ" to 27, "قاتل" to 27, "اسلشر" to 27, "طلسم" to 27,
        "احضار" to 27, "شیطان" to 27, "خوناشام" to 27, "ومپایر" to 27, "گرگینه" to 27, "ترسناک" to 27,
        // انگلیسی
        "scary" to 27, "horror" to 27, "ghost" to 27, "fear" to 27, "blood" to 27,
        "zombie" to 27, "dark" to 27, "demon" to 27, "vampire" to 27, "creepy" to 27,


        "غم" to 18, "گریه" to 18, "ناراحت" to 18, "درام" to 18, "افسرده" to 18, "جدی" to 18,
        "بغض" to 18, "تنها" to 18, "تنهایی" to 18, "اجتماعی" to 18, "سنگین" to 18, "بدبخت" to 18,
        "شکست" to 18, "مرگ" to 18, "سوگ" to 18, "اشک" to 18, "سیاه" to 18,
        "sad" to 18, "drama" to 18, "cry" to 18, "depressed" to 18, "lonely" to 18,
        "tears" to 18, "upset" to 18, "emotional" to 18,


        "فضا" to 878, "آینده" to 878, "فضایی" to 878, "تکنولوژی" to 878, "ربات" to 878,
        "علمی" to 878, "تخیلی" to 878, "سفینه" to 878, "مریخ" to 878, "هوش مصنوعی" to 878,
        "زمان" to 878, "کهکشان" to 878, "بیگانگان" to 878, "آدم فضایی" to 878,
        "sci-fi" to 878, "space" to 878, "future" to 878, "robot" to 878, "alien" to 878,
        "galaxy" to 878, "technology" to 878, "ai" to 878,


        "جنایی" to 80, "پلیس" to 80, "دزد" to 80, "قتل" to 80, "کارآگاه" to 80, "مافیا" to 80,
        "گانگستر" to 80, "زندان" to 80, "سرقت" to 80, "قانون" to 80, "خلاف" to 80, "مواد" to 80,
        "معمایی" to 9648, "راز" to 9648, "مرموز" to 9648, "پازل" to 9648, "عجیب" to 9648,
        "پیچیده" to 9648, "ذهنی" to 9648, "سوال" to 9648, "جستجو" to 9648,
        "crime" to 80, "police" to 80, "detective" to 80, "murder" to 80, "mafia" to 80,
        "mystery" to 9648, "secret" to 9648, "puzzle" to 9648, "suspect" to 9648,



        "جادو" to 14, "فانتزی" to 14, "اژدها" to 14, "جادوگر" to 14, "پری" to 14,
        "افسانه" to 14, "قدرت" to 14, "خیالی" to 14, "طلسم" to 14, "هری پاتر" to 14, "ارباب حلقه ها" to 14,
        "سفر" to 12, "ماجراجویی" to 12, "طبیعت" to 12, "جنگل" to 12, "کوه" to 12,
        "گنج" to 12, "اکتشاف" to 12, "جهانگردی" to 12, "کمپ" to 12, "نقشه" to 12,
        "fantasy" to 14, "magic" to 14, "dragon" to 14, "wizard" to 14,
        "adventure" to 12, "travel" to 12, "journey" to 12, "explore" to 12
    )

    fun extractGenreIds(userText: String): String {
        val foundGenres = mutableSetOf<Int>()
        // متن رو نرمال میکنیم (حروف کوچک + حذف علائم نگارشی اضافه)
        val cleanedText = userText.lowercase()
            .replace(Regex("[.!?,،:;]"), " ") // حذف علائم

        val words = cleanedText.split(" ").filter { it.isNotBlank() }

        words.forEach { word ->
            keywordToGenre.forEach { (keyword, id) ->
                // استفاده از contains برای پیدا کردن کلمات مشابه (مثل "ترسناکه" -> "ترس")
                if (word.contains(keyword)) {
                    foundGenres.add(id)
                }
            }
        }

        // اگر کاربر چیزی نوشت که پیدا نشد، لااقل محبوب‌ترین‌ها رو برگردون (اختیاری)
        // if (foundGenres.isEmpty()) return "35,28"

        return foundGenres.joinToString(",")
    }
}