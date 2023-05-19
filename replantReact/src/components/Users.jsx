import api from "../services/api";
import { useEffect, useState } from "react";

const Users = () => {
    const [users, setUsers] = useState([]);

    function getUsers() {
        const options = {
            method: "GET",
            url: "/users",
        };

        api
            .request(options)
            .then((response) => {
                setUsers(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    useEffect(() => {
        getUsers();
    }, []);

    return (
        <div>
            {users.map((user) => (
                <div>
                    <h1 key={user.id}>{user.name}</h1>
                    <span>{user.url}</span><br></br>
                    <span>{user.region}</span>
                </div>
            ))}
        </div>
    );
};

export default Users;