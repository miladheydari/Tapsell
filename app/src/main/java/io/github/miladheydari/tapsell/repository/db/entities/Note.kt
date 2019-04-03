package io.github.miladheydari.tapsell.repository.db.entities


import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "note")
data class Note(val note: String ){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
