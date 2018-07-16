/**
 * MercadoLibre service
 * 
 * Adds a global service. 
 * It should be used like mercadoLibreService.findProductsByName('foo').done(function(result){});
 * @author mcurrao
 */
(function ($) {
    const ML_SEARCH_ENDPOINT = 'https://api.mercadolibre.com/sites/MLA/search';

    var mercadoLibreService = {};
    window.mercadoLibreService = mercadoLibreService;

    mercadoLibreService.findProductsByName = findProductsByName;

    /**
     * Performs a search against MercadoLibre api
     * 
     * Result is returned paginated, and with extra info provided by ML.
     * Meaningfull results are under response.results.
     * Meaningull info is under:
     * * result.id
     * * result.permalink
     * * result.thumbnail
     * * result.title
     * @param {string}  searchValue 
     * @param {int}     limit optional limit. Defaults to 10.
     * @return {jQuery.Deferred} resolution promise
     */
    function findProductsByName(searchValue, limit) {

        var dfd = jQuery.Deferred();

        $.ajax({
            url: ML_SEARCH_ENDPOINT,
            method: "GET",
            data: {
                q: searchValue,
                limit: limit
            }
        }).done(response => dfd.resolve(response));

        return dfd.promise();
    }
})(jQuery);