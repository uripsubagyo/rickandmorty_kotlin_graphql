import android.util.Log
import com.example.rickandmortyapi.LocationQuery
import com.example.rickandmortyapi.LocationsQuery
import com.example.rickandmortyapi.domain.model.Location.DetailLocation
import com.example.rickandmortyapi.domain.model.Location.ResidenceCharacter
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation


fun LocationsQuery.Locations.toLocationList(): List<SimpleLocation> {
    Log.d("Mapper_2", "data: ${results?.getOrNull(0) ?: "empty"}")

    return this.results?.mapNotNull { result ->
        SimpleLocation(
            id = result?.id.orEmpty(),
            name = result?.name.orEmpty(),
            type = result?.type.orEmpty()
        )
    }.orEmpty()
}


fun LocationQuery.Location.toDetailLocation() : DetailLocation =
    DetailLocation(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        type = this.type.orEmpty(),
        dimension = this.dimension.orEmpty(),
        created = this.created.orEmpty(),
        residents = this.residents?.mapNotNull {
            result -> ResidenceCharacter(
                name = result?.name.orEmpty(),
                status =  result?.status.orEmpty(),
                gender = result?.gender.orEmpty(),
                image = result?.image.orEmpty(),
                type = result?.type.orEmpty()
            )
        }.orEmpty()
    )