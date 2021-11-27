$(document).ready(function () {
    //$('#personas').hide();
    $('#buscar').on('click', function () {
        var dni = $('#txtDni').val();
        $.ajax({
            type: 'GET',
            //Ingresa a La Pagina de dniruc.apisperu.com y Crea Tu Cuenta Ahy Te Daran Tu Token Propio 
            url: 'https://dniruc.apisperu.com/api/v1/dni/' + dni + '?token=TUPROPIOTOKEN',
            dataType: 'JSON'

        }).done((data) => {
            //console.log(data);
            let fila = $('<tr>');
            fila.append($(`<td>${data.dni}</td>`));
            fila.append($(`<td>${data.nombres}</td>`));
            fila.append($(`<td>${data.apellidoPaterno}</td>`));
            fila.append($(`<td>${data.apellidoMaterno}</td>`));
            $('#personas>tbody').append(fila);

            $('#personas').show();
        });

    });

});
