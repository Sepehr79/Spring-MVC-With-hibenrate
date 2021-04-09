function configuration(){
    document.getElementById("deleteLink").addEventListener('click', function (e){
        if (!confirm("Are you sure to delete?"))
            e.preventDefault()
    })
}