# Getting Started

### API Endpoints
The following guides illustrate how to use some features concretely:

* [Generate new DeckID](http//:localhost:1010/deckofcards/generate-new-deck-id)
* [Gen Next Card in the Deck](http://localhost:1010/deckofcards/getnext-card-in-deck?deckID=${deckID}&locationID=${locationID})
* [Building REST services with Spring](http://localhost:1010/deckofcards/skipnext-card-in-deck?deckID=${deckID}&locationID=${locationID})

### Docker commands
The following guides illustrate how to use some features concretely:
* [Docker Build Image] : docker build -t praveen-singh1/deckofcards .
* [Docker run container] : docker run -p 1010:1010 praveen-singh1/deckofcards

### Postman collection for testing
* [DeckOfCards.postman_collection.json] : Run in the postman as collection