package com.example.kandilliapp.view

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.kandilliapp.model.Response
import com.example.kandilliapp.model.Result
import com.example.kandilliapp.viewModel.HomeScreenViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun HomeScreen(earthquakeList: List<Result>, viewModel: HomeScreenViewModel) {

    //It's depreceted now, use Box.pullState.
    //https://stackoverflow.com/questions/67204979/there-is-something-similar-like-swiperefreshlayout-to-pull-to-refresh-in-the-laz

    SwipeRefresh(
        state = rememberSwipeRefreshState(viewModel.isRefreshing),
        onRefresh = { viewModel.getEarthquakeList() },
    ) {

        LazyColumn() {
            itemsIndexed(items = earthquakeList) { index, item ->
                EarthquakeItem(earthquake = item)
            }
        }
    }


}


@Composable
fun EarthquakeItem(earthquake: Result) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(250.dp), shape = RoundedCornerShape(8.dp)

    ) {

        Column(
            Modifier
                .padding(4.dp)
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(139, 195, 74, 255), Color(205, 220, 57, 255),Color(
                            255,
                            235,
                            59,
                            255
                        )
                        ),

                        )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = earthquake.title.toString(), fontSize = 25.sp, textAlign = TextAlign.Center)
            Text(text = "Şehir : " + earthquake.location_properties.epiCenter.name.toString())
            Text(text = "Tarih : " + earthquake.date_day)
            Text(text = "Saat : " + earthquake.date_hour)
            Text(text = "Büyüklük : " + earthquake.mag.toString())
            Text(text = "Derinlik : " + earthquake.depth.toString() + "KM")

        }

    }

}

/*
Row(
            Modifier
                .padding(4.dp)
                .fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = earthquake.mag.toString())
        }

        ConstraintLayout() {

            val (title, nameEpiCenter, location, date, depth ) = createRefs()



        }

 */