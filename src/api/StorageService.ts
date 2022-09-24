import axios from "axios";

export default class StorageService {

    static async getAllInfo() {

        try {

            const response = await axios.get('http://localhost:9992/api/warehouse/info');
            return response.data;

        } catch (e) {

            console.log(e);

        }
    }



}