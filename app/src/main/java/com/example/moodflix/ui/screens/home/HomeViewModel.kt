package com.example.moodflix.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodflix.data.remote.RetrofitInstance
import com.example.moodflix.utils.Constants
import com.example.moodflix.utils.MoodAnalyzer
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    // متغیرهای داخلی برای مدیریت صفحات
    private var currentPage = 1
    private var currentGenreIds = ""
    private var isLastPageReached = false

    // ۱. وقتی کاربر دکمه جستجو را می‌زند
    fun onUserSubmitMood(text: String) {
        if (text.isBlank()) return

        // ریست کردن همه چیز برای جستجوی جدید
        currentPage = 1
        isLastPageReached = false
        currentGenreIds = MoodAnalyzer.extractGenreIds(text)

        // لیست را خالی می‌کنیم و لودینگ را روشن می‌کنیم
        uiState = uiState.copy(movies = emptyList(), isLoading = true, error = null)

        if (currentGenreIds.isEmpty()) {
            uiState = uiState.copy(isLoading = false, error = "متوجه نشدم! لطفا از کلمات کلیدی (مثل جنگی، خنده دار، عاشقانه) استفاده کن.")
            return
        }

        fetchMovies()
    }

    // ۲. وقتی کاربر به پایین لیست می‌رسد (برای دریافت صفحه بعد)
    fun loadNextPage() {
        // اگر در حال لود هستیم یا فیلم‌ها تمام شده، کاری نکن
        if (uiState.isLoading || isLastPageReached) return

        currentPage++
        uiState = uiState.copy(isLoading = true) // لودینگ کوچک روشن شود
        fetchMovies()
    }

    // ۳. تابع اصلی درخواست به سرور
    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMoviesByGenre(
                    apiKey = Constants.API_KEY,
                    genreIds = currentGenreIds,
                    page = currentPage // شماره صفحه فعلی
                )

                if (response.results.isEmpty()) {
                    isLastPageReached = true // دیگر فیلمی وجود ندارد
                }

                // لیست جدید را به تهِ لیست قدیمی می‌چسبانیم (Append)
                val updatedList = uiState.movies + response.results

                uiState = uiState.copy(
                    movies = updatedList,
                    isLoading = false,
                    error = if (updatedList.isEmpty()) "فیلمی با این مشخصات پیدا نشد." else null
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "خطا در اتصال: ${e.localizedMessage} \n(VPN را چک کنید)"
                )
            }
        }
    }
}