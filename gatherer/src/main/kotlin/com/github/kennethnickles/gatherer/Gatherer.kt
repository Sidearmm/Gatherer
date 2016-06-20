package com.github.kennethnickles.gatherer

import com.github.kennethnickles.gatherer.card.Card
import com.github.kennethnickles.gatherer.server.DeckBrewService
import com.github.kennethnickles.gatherer.server.GathererRequest
import com.github.kennethnickles.gatherer.server.GathererService
import com.github.kennethnickles.gatherer.util.CardGsonFactory
import com.github.kennethnickles.gatherer.util.Preconditions
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer

/**
 * @author kenneth.nickles
 * *
 * @since 2015-06-27.
 * *
 * * Static singleton for doing simple requests to Deckbrew or Gatherer
 */
object Gatherer {

    /**
     * Hits DeckBrew Api
     */
    fun cards(request: GathererRequest, observer: Observer<List<Card>>) {
        Preconditions.checkArgument(request != null, "request")
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).cards(request.getDeckBrewParams()).subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun card(id: String, observer: Observer<Card>) {
        Preconditions.checkArgument(id != null, "id")
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).card(id).subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun typeahead(query: String, observer: Observer<List<Card>>?) {
        Preconditions.checkArgument(query != null, "query")
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).typeahead(query).subscribe(observer)

    }

    /**
     * Hits DeckBrew Api
     */
    fun sets(observer: Observer<List<String>>) {
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).sets().subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun types(observer: Observer<List<String>>) {
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).types().subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun supertypes(observer: Observer<List<String>>) {
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).supertypes().subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun subtypes(observer: Observer<List<String>>) {
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).subtypes().subscribe(observer)
    }

    /**
     * Hits DeckBrew Api
     */
    fun colors(observer: Observer<List<String>>) {
        Preconditions.checkArgument(observer != null, "observer")
        val gson = CardGsonFactory().createCardGson()
        val retrofit = Retrofit.Builder().baseUrl("https://api.deckbrew.com/").addConverterFactory(
                GsonConverterFactory.create(gson)).build()
        retrofit.create(DeckBrewService::class.java).colors().subscribe(observer)
    }

    /**
     * Hits Gatherer Scraper TODO: HtmlScraperFactory
     */
    fun simple(request: GathererRequest, observer: Observer<List<Card>>) {
        Preconditions.checkArgument(request != null, "request")
        Preconditions.checkArgument(observer != null, "observer")
        val retrofit = Retrofit.Builder().baseUrl("http://gatherer.wizards.com/").build()
        retrofit.create(GathererService::class.java).simple(request.getGathererParams()).subscribe(observer)
    }

    /**
     * Hits Gatherer Scraper TODO: HtmlScraperFactory
     */
    fun advanced(request: GathererRequest, observer: Observer<List<Card>>) {
        Preconditions.checkArgument(request != null, "request")
        Preconditions.checkArgument(observer != null, "observer")
        val retrofit = Retrofit.Builder().baseUrl("http://gatherer.wizards.com/").build()
        retrofit.create(GathererService::class.java).advanced("advanced", request.getGathererParams()).subscribe(
                observer)
    }

    /**
     * Hits Gatherer Scraper TODO: HtmlScraperFactory
     */
    fun detail(multiverseId: String, observer: Observer<Card>) {
        Preconditions.checkArgument(multiverseId != null, "multiverseId")
        Preconditions.checkArgument(observer != null, "observer")
        val retrofit = Retrofit.Builder().baseUrl("http://gatherer.wizards.com/").build()
        retrofit.create(GathererService::class.java).detail(multiverseId).subscribe(observer)
    }

    /**
     * Hits Gatherer Scraper TODO: HtmlScraperFactory
     */
    fun random(observer: Observer<Card>) {
        Preconditions.checkArgument(observer != null, "observer")
        val retrofit = Retrofit.Builder().baseUrl("http://gatherer.wizards.com/").build()
        retrofit.create(GathererService::class.java).random("random").subscribe(observer)
    }
}
