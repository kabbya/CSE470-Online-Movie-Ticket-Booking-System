console.log("This is script file")

const toggleSidebar = () => {

    if($(".sidebar").is(":visible")){

        $(".sidebar").css("display", "none");
        $(".content").css("margin-left", "0%");

    }

    else{
        $(".sidebar").css("display", "block");
        $(".content").css("margin-left", "20%");
    }
};

const searchByMovieNameAdmin = () => {
    //console.log("Searching...")
    let query = $("#searchInput").val();
  
    if(query == ""){
        $(".search-result").hide();
    }else{

        // search
        console.log(query);
        let url = `http://localhost:9292/search/${query}`;

        fetch(url)
            .then( (response) => {
                return response.json();
            })
            .then( (data) => {

                let text=`<div class='list-group'>`;

                data.forEach( (movieTicket) => {
                    text+=`<a href='/admin/update-movie-form/${movieTicket.movieId}' class='list-group-item list-group-action'> ${movieTicket.movieName} </a>`
                });

                text+=`</div>`;

                $(".search-result").html(text);
                $(".search-result").show();
            });
    }
};


const searchByMovieNameUser = () => {
    //console.log("Searching...")
    let query = $("#searchInput").val();
  
    if(query == ""){
        $(".search-result").hide();
    }else{

        // search
        console.log(query);
        let url = `http://localhost:9292/search/${query}`;

        fetch(url)
            .then( (response) => {
                return response.json();
            })
            .then( (data) => {

                let text=`<div class='list-group'>`;

                data.forEach( (movieTicket) => {
                    text+=`<a href='/user/buy-movie-ticket/${movieTicket.movieId}' class='list-group-item list-group-action'> ${movieTicket.movieName} </a>`
                });

                text+=`</div>`;

                $(".search-result").html(text);
                $(".search-result").show();
            });
    }
};