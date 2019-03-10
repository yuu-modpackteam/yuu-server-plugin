package yuu.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class SeasonChangeEvent : Event() {
    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}

enum class Seasons {
    SPRING,
    SUMMER,
    FALL,
    WINTER,

    ;
}