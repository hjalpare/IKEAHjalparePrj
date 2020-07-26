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

    var furnitureService = mockk<FurnitureService>()
/*
    @Test
    fun confirmKopangDrawerDresser_outputsKopangDrawerDresser () {
        var furniture: Furniture = Furniture(1001, "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf", "https://www.youtube.com/watch?v=biL6K6OESe4", "KOPPANG", "asdasdf")
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
        var allFurnituresLiveData = MutableLiveData<ArrayList<Furniture>>()
        var allFurnitures = ArrayList<Furniture>()
        //create and add plants to our collection.
        var KopangDrawerDresser = Furniture(1001, "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf", "https://www.youtube.com/watch?v=biL6K6OESe4", "KOPPANG", "asdfasdf")
        allFurnitures.add(KopangDrawerDresser)
        var KopangLamp = Furniture(1001, "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf", "https://www.youtube.com/watch?v=biL6K6OESe4", "KOPPANG", "asdfasdf")
        allFurnitures.add(KopangLamp)

        allFurnituresLiveData.postValue(allFurnitures)
        every{furnitureService.fetchFurnitures(any<String>())} returns allFurnituresLiveData
        mvm.furnitureService = furnitureService
    }

    private fun whenSearchForKopangDrawerDresser() {
        mvm.fetchFurnitures("KopangDrawerDresser")
    }

    private fun thenResultContainsDrawerDresser() {
        var KopangDrawerDresserFound = false;
        mvm.furnitures.observeForever {
            //do observing here
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach {
                if (it.instructionsManuel == "https://www.ikea.com/us/en/assembly_instructions/koppang-drawer-dresser__AA-2066877-1_pub.pdf" && it.videoLink == "https://www.youtube.com/watch?v=biL6K6OESe4"){
                    KopangDrawerDresserFound = true
                }

            }
        }
        assertTrue(KopangDrawerDresserFound)
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
    }*/
}