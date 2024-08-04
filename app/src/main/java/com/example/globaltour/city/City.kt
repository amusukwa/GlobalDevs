package com.example.globaltour.city

import com.example.globaltour.R


data class City(var imageId: Int, var name: String, var isFavorite: Boolean)


object VacationSpots {

    private val images = arrayListOf (
//        R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
//        R.drawable.thumb_4_4, R.drawable.thumb_4_7, R.drawable.thumb_4_8,
//        R.drawable.thumb_4_0, R.drawable.thumb_7_0, R.drawable.thumb_7_1,
//        R.drawable.thumb_7_2, R.drawable.thumb_4_5, R.drawable.thumb_4_6,
//        R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2,
//        R.drawable.thumb_1_3, R.drawable.thumb_1_4, R.drawable.thumb_1_5,
//        R.drawable.thumb_1_6, R.drawable.thumb_1_7, R.drawable.thumb_1_8,
//        R.drawable.thumb_1_9, R.drawable.thumb_2_0, R.drawable.thumb_2_1,
//        R.drawable.thumb_4_9, R.drawable.thumb_5_0, R.drawable.thumb_5_1,
//        R.drawable.thumb_5_2, R.drawable.thumb_5_3, R.drawable.thumb_5_4,
//        R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
//        R.drawable.thumb_5_8, R.drawable.thumb_5_9, R.drawable.thumb_6_0,
//        R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
//        R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6,
//        R.drawable.thumb_6_7, R.drawable.thumb_6_8, R.drawable.thumb_6_9,
//        R.drawable.thumb_2_2, R.drawable.thumb_2_3, R.drawable.thumb_2_4,
//        R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
//        R.drawable.thumb_2_8, R.drawable.thumb_2_9, R.drawable.thumb_3_0,
//        R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
//        R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6,
 //       R.drawable.thumb_3_7, R.drawable.thumb_3_8, R.drawable.thumb_3_9,
  //      R.drawable.thumb_7_3, R.drawable.thumb_7_4,
        R.drawable.thumb_7_5,R.drawable.thumb_7_6,
        R.drawable.thumn_7_7, R.drawable.thumb_7_8,R.drawable.thumb_7_9
    )

    private val cityNames = arrayListOf(
//        "New Delhi", "Manchester", "Nottingham", "Portsmouth", "Agra",
//        "Hyderabad", "Goa", "Srinagar", "Xian", "Shanghai",
//        "Buffalo", "Boise", "Pittsburgh", "Scottsdale", "Boston",
//        "Philly", "Darjeeling", "Jaipur", "DC", "Minneapolis",
//        "New York City", "Denver", "Asheville", "Hull", "Liverpool",
//        "Detroit", "Adelaide", "Tasmania", "Austin", "Kansas City", "Seattle",
//        "Oakland", "Las Vegas", "New Orleans", "Bath", "Norwich",
//        "Mumbai", "Cambridge", "London", "Bristol", "Brighton", "Durham",
//        "San Diego", "Brooklyn", "Chicago", "Charleston", "Nashville",
//        "York", "Stratford-upon-Avon", "Bournemouth", "Beijing",
//        "Miami", "Portland", "Chengdu", "Hangzhou", "Suzhou", "Huangshan",
//        "Hong Kong", "Cairns", "Perth", "Brisbane",
      "Blantyre", "Lilongwe", "Nairobi", "Lusaka",
        "Lwanda", "California",
        "Japan","S.Korea", "Isreal","Nigeria"
    )

    // Returns the list of city objects to be displayed in CityListFragment RecyclerView
    var  cityList: ArrayList<City>? = null
        get() {

            if (field != null)      // backing 'field' refers to 'cityList' property object
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val cityName = cityNames[i]
                val city = City(imageId, cityName, false)
                field!!.add(city)
            }

            return field
        }

    // Will contain the 'favorite' marked cities to be displayed in FavoriteFragment RecyclerView
    var favoriteCityList: MutableList<City> = mutableListOf()
}
