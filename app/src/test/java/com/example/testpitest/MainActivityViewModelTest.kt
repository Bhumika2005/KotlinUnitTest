package com.example.testpitest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityViewModelTest {

    private lateinit var sut: MainActivityViewModel
    private var dispatcher: CoroutineDispatcher = mockk(relaxed = true)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        sut = MainActivityViewModel()
    }

    @Test
    fun `test button click`() {
        /*coEvery { sut.isImageVisible } returns MutableLiveData(false)
        coEvery { sut.updateName } returns MutableLiveData("Show Image")*/

        sut.buttonClick()

        Truth.assertThat(sut.isImageVisible.value).isEqualTo(true)
        Truth.assertThat(sut.updateName.value).isEqualTo("Hide Image")
    }
}