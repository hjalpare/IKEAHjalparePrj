package edu.uc.kansakpb.ikeahjalpare3

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import edu.uc.kansakpb.ikeahjalpare3.service.FurnitureService
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FurnitureDataUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    private var furnitureService = mockk<FurnitureService>()

    @Test
    fun confirmKopangDrawerDresser_outputsKopangDrawerDresser () {
        val furniture = Furniture(
            1,
            "https://www.youtube.com/watch?v=biL6K6OESe4",
            "",
            "KopangLamp",
            "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf")
        assertEquals("https://www.youtube.com/watch?v=biL6K6OESe4", furniture.toString())
    }

    @Test
    fun searchForKopangDrawerDresser_returnsKopangDrawerDresser() {
        givenAFeedOfMockedFurnitureDataAreAvailable()
        whenSearchForKopangDrawerDresser()
        thenResultContainsDrawerDresser()
    }

    private fun givenAFeedOfMockedFurnitureDataAreAvailable() {
        mvm = MainViewModel()
        createMockData()
    }

    private fun createMockData() {
        val allFurnituresLiveData = MutableLiveData<ArrayList<Furniture>>()
        val allFurnitures = ArrayList<Furniture>()
        //create and add furnitures to our collection.
        val kopangDrawerDresser = Furniture(
            0,
            "https://www.youtube.com/watch?v=biL6K6OESe4",
            "",
            "KopangDrawerDresser",
            "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf")
        allFurnitures.add(kopangDrawerDresser)
        val kopangLamp = Furniture(
            1,
            "https://www.youtube.com/watch?v=biL6K6OESe4",
            "",
            "KopangLamp",
            "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf")
        allFurnitures.add(kopangLamp)

        allFurnituresLiveData.postValue(allFurnitures)
        every{furnitureService.fetchFurnitures(any())} returns allFurnituresLiveData
        mvm.furnitureService = furnitureService
    }

    private fun whenSearchForKopangDrawerDresser() {
        mvm.fetchFurnitures("KopangDrawerDresser")
    }

    private fun thenResultContainsDrawerDresser() {
        var kopangDrawerDresserFound = false;
        mvm.furnitures.observeForever { it ->
            //do observing here
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach {
                if (it.instructionsManuel == "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf" && it.videoLink == "https://www.youtube.com/watch?v=biL6K6OESe4"){
                    kopangDrawerDresserFound = true
                }
            }
        }
        assertTrue(kopangDrawerDresserFound)
    }

    @Test
    fun searchForGarbage_returnsNothing(){
        givenAFeedOfMockedFurnitureDataAreAvailable()
        whenISearchForGarbage()
        thenIGetZeroResults()
    }

    private fun whenISearchForGarbage() {
        mvm.fetchFurnitures("asdfasdfwrvqfasd")
    }

    private fun thenIGetZeroResults() {
        mvm.furnitures.observeForever {
            assertEquals(0, it.size)
        }
    }
}