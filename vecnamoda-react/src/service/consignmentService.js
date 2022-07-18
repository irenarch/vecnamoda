import axios from "./http.js";

const apiUri = "api/consignments";

export const createConsignment = () => {
    return axios.post(`${apiUri}`);
}

export const getConsignmentByToken = (token) => {
    return axios.get(`${apiUri}/${token}`);
}