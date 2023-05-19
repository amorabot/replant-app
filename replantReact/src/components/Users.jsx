import api from '../services/api';
import { useEffect, useState } from 'react';

const Users = () => {

    const [users, setUsers] = useState();

    const getUsers = async () => {
        const option = {
            method: "GET",
            url: "/users"
        }

        // api.request(option).then((response) => {
        //     console.log(response.data);
        //     // setUsers(response.data);
        // }).catch((error) => {
        //     console.log(error);
        //) }
        try {
            const response = await api.request(option)
            setUsers(response.data);
            console.log(response);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getUsers()
    }, [])


    return (
            <div>
                {users.map(user => {
                    <span>{user.name}</span>
                })}
                {/* <span>{users}</span> */}
            </div>
    )
}

export default Users;

