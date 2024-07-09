package com.pes.adjudicat.presentation.freatures.licitacionsList

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.pes.adjudicat.data.models.Filtres
import com.pes.adjudicat.presentation.components.LicitacioElement
import com.pes.adjudicat.presentation.freatures.filterBox.FilterElement
import kotlinx.coroutines.flow.distinctUntilChanged


/**
 * Composable que mostre una llista de licitacions
 * @param viewModel view Model que conte tota la logica de la llista
 */
@Composable
fun LicitacionList(
    viewModel: LicitacionsListViewModel,
    visible: Boolean,
    navigateToDetails: (Int) -> Unit,
    key : String
){
    val listState = rememberLazyListState()

    // Llista amb scroll que mostre totes les licitacions
    if (! viewModel.errorMessage.isEmpty())  Text(text = viewModel.errorMessage)

    LazyColumn(
        state = rememberForeverLazyListState(key = key),
        modifier = Modifier
            .padding(
                top = 12.dp,
                start = 12.dp,
                end = 12.dp,
                bottom = 0.dp
            )
            .clip(
                RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .animateContentSize(),
        // Espai entre elements
        verticalArrangement = Arrangement.spacedBy(3.dp),
    ) {
            val mutableList = mutableListOf<String>()
            if (visible) {
                val filtres = Filtres("",false,false,mutableList,0,0,"","","","");
                item {
                    FilterElement(modifier = Modifier
                        .size(1000.dp)
                        .fillParentMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.DarkGray) ,
                        filtres = filtres)
                }
            }

        items(viewModel.licitacions) { licitacio ->
            LicitacioElement(
                licitacio = licitacio,
                onToggleSave = {},//TODO afegir funcio de like (Sprint 2)
                navigateToDetails = navigateToDetails
            )
        }
    }

    InfiniteListHandler(listState = listState) {
        viewModel.loadMore();
    }
}


@Composable
fun InfiniteListHandler(
    listState: LazyListState,
    buffer: Int = 2,
    onLoadMore: () -> Unit
) {
    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

            lastVisibleItemIndex > (totalItemsNumber - buffer)
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .distinctUntilChanged()
            .collect {
                onLoadMore()
            }
    }
}



/**
 * Static field, contains all scroll values
 */
private val SaveMap = mutableMapOf<String, KeyParams>()

private data class KeyParams(
    val params: String = "",
    val index: Int,
    val scrollOffset: Int
)

/**
 * Save scroll state on all time.
 * @param key value for comparing screen
 * @param params arguments for find different between equals screen
 * @param initialFirstVisibleItemIndex see [LazyListState.firstVisibleItemIndex]
 * @param initialFirstVisibleItemScrollOffset see [LazyListState.firstVisibleItemScrollOffset]
 */
@Composable
fun rememberForeverLazyListState(
    key: String,
    params: String = "",
    initialFirstVisibleItemIndex: Int = 0,
    initialFirstVisibleItemScrollOffset: Int = 0
): LazyListState {
    val scrollState = rememberSaveable(saver = LazyListState.Saver) {
        var savedValue = SaveMap[key]
        if (savedValue?.params != params) savedValue = null
        val savedIndex = savedValue?.index ?: initialFirstVisibleItemIndex
        val savedOffset = savedValue?.scrollOffset ?: initialFirstVisibleItemScrollOffset
        LazyListState(
            savedIndex,
            savedOffset
        )
    }
    DisposableEffect(Unit) {
        onDispose {
            val lastIndex = scrollState.firstVisibleItemIndex
            val lastOffset = scrollState.firstVisibleItemScrollOffset
            SaveMap[key] = KeyParams(params, lastIndex, lastOffset)
        }
    }
    return scrollState
}




