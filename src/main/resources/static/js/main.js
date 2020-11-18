(function() {
    'use strict';

    /* full screen section
    const element = $('#image')[0];
    $('#image').on('click', () => {
        if (screenfull.isEnabled) {
            screenfull.toggle(element);
        } else {
            alert("can't full screen")
        }
    });

    document.getElementById('image').addEventListener('click', () => {
        alert("click")
    	if (screenfull.isEnabled) {
    	    const element = document.getElementById('image');
    		screenfull.request(element);
    	}
    });
    */

    // data binding to ui
    var vm = new Vue({
        el: '#app',
        data: {
            photo: null,
            photoList: [],
            medias: [],
            count: 5
        },
        methods: {
            changePhoto: function () {
                var photoLength = this.photoList.length;
                if ( photoLength == 0 ) {
                    this.getInstagram();
                    for ( var i = 0; i < this.medias.length; i++ ) {
                        this.photoList.push(this.medias[i].mediaUrl);
                        console.log(this.medias[i].mediaUrl);
                    };
                };
                var random = Math.floor( Math.random() * photoLength ) ;
                this.photo = this.photoList[random];
                this.photoList.splice(random,1);
                this.countDown();
            },
            countDown: function () {
                if(this.count > 0) {
                    setTimeout(() => {
                        this.count -= 1;
                        this.countDown();
                    },1000)
                } else {
                    this.count = 5;
                    this.changePhoto();
                }
            },
            getInstagram: function () {
                axios
                    .get('http://35.209.183.156:80/instagram/v1/get/instagramlist')
                    .then(response => (this.medias = response.data.medias));
            }
        },
        created() {
            this.changePhoto();
        }
    })
})();

