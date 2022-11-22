API THAT ARE USED

BASE URL = "https://dev.api.apnicare.in/"
API_KEY =""

Product List :

Searching API :
    @Get
    /drug/
    
    https://dev.api.apnicare.in/drug/?page=1&search=dolo

        Structure :
                        {
                    "page": 0,
                    "pages": 0,
                    "total": 0,
                    "per_page": 0,
                    "next_num": 0,
                    "prev_num": 0,
                    "has_next": true,
                    "has_prev": true,
                    "items": [
                            {
                            "cart_id": 0,
                            "cart_quantity": 0,
                            "slug": "string",
                            "name": "string",
                            "price": 0,
                            "mrp": 0,
                            "available": true,
                            "prescription_required": false,
                            "pack": "string",
                            "image": {
                            "name": "string",
                            "original_path": "string",
                            "thumbnail_path": "string",
                            "small_path": "string",
                            "medium_path": "string",
                            "large_path": "string"
                            }

USER :

