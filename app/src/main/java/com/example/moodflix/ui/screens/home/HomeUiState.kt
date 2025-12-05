package com.example.moodflix.ui.home

import com.example.moodflix.data.model.MovieDto

data class HomeUiState(
    // لیست فیلم‌ها (که قراره کم‌کم زیاد بشه)
    val movies: List<MovieDto> = emptyList(),

    // وضعیت لودینگ (هم برای جستجوی اول، هم برای صفحات بعدی)
    val isLoading: Boolean = false,

    // پیام خطا
    val error: String? = null
)